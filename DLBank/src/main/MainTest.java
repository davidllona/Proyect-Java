package main;

import components.Account;
import components.Client;
import components.Credit;
import components.CurrentAccount;
import components.Debit;
import components.Flow;
import components.SavingsAccount;
import components.Transfer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        // Generate a test set of clients
        Client[] clients = generateTestClients(3);

        // Display the test set of clients
        displayClients(clients);

        // Load and display the Hashtable of accounts
        Hashtable<Integer, Account> accountHashtable = loadAccounts(clients);
        displayHashtableInAscendingOrder(accountHashtable);
        
     // Create and display the array of flows
        Flow[] flows = createFlows(accountHashtable);
        displayFlows(flows);
    }

    private static Client[] generateTestClients(int numberOfClients) {
        // Create and return an array of test clients
        Client[] clients = new Client[numberOfClients];
        for (int i = 0; i < numberOfClients; i++) {
            clients[i] = new Client("name" + (i + 1), "firstname" + (i + 1));
        }
        return clients;
    }

    private static void displayClients(Client[] clients) {
        // Display the contents of the array of clients using a stream
        System.out.println("Test Set of Clients:");
        for (Client client : clients) {
            System.out.println(client);
        }
        System.out.println();
    }

    private static Hashtable<Integer, Account> loadAccounts(Client[] clients) {
        // Create a Hashtable to store the accounts
        Hashtable<Integer, Account> accountHashtable = new Hashtable<>();

        // Generate a savings account and a current account per client with zero balances
        for (Client client : clients) {
            SavingsAccount savingsAccount = new SavingsAccount("Savings Account", client);
            CurrentAccount currentAccount = new CurrentAccount("Current Account", client);

            accountHashtable.put(savingsAccount.getAccountNumber(), savingsAccount);
            accountHashtable.put(currentAccount.getAccountNumber(), currentAccount);
        }

        // Return the Hashtable
        return accountHashtable;
    }

    private static void displayHashtableInAscendingOrder(Hashtable<Integer, Account> accountHashtable) {
        // Display the contents of the Hashtable in ascending order according to the balance
        System.out.println("Hashtable of Accounts (Ascending Order by Balance):");
        accountHashtable.entrySet()
                .stream()
                .sorted((entry1, entry2) -> Double.compare(entry1.getValue().getBalance(), entry2.getValue().getBalance()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
    
    
    private static Flow[] createFlows(Hashtable<Integer, Account> accountHashtable) {
        List<Flow> flows = new ArrayList<>();

        // Date of flows: operations are carried out 2 days after the creation of flows
        LocalDate dateOfFlows = LocalDate.now().plusDays(2);

        // Debit of 50€ from account n°1
        flows.add(new Debit("Debit from Account 1", 1, 50, 1, true, convertToDate(dateOfFlows)));

        // Credit of 100.50€ on all current accounts
        for (Account account : accountHashtable.values()) {
            if (account instanceof CurrentAccount) {
                flows.add(new Credit("Credit to Current Account", 2, 100.50, account.getAccountNumber(), true, convertToDate(dateOfFlows)));
            }
        }

        // Credit of 1500€ on all savings accounts
        for (Account account : accountHashtable.values()) {
            if (account instanceof SavingsAccount) {
                flows.add(new Credit("Credit to Savings Account", 3, 1500, account.getAccountNumber(), true, convertToDate(dateOfFlows)));
            }
        }

        // Transfer of 50 € from account n ° 1 to account n ° 2
        flows.add(new Transfer("Transfer from Account 1 to Account 2", 4, 50, 2, true, convertToDate(dateOfFlows), 1));

        return flows.toArray(new Flow[0]);
    }

    private static void displayFlows(Flow[] flows) {
        System.out.println("Array of Flows:");
        for (Flow flow : flows) {
            System.out.println(flow);
        }
    }

    private static Date convertToDate(LocalDate localDate) {
        // Convert LocalDate to Date
        return java.sql.Date.valueOf(localDate);
    }
}
