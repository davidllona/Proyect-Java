package main;

import components.Account;
import components.Client;
import components.CurrentAccount;
import components.SavingsAccount;

import java.util.Hashtable;

public class MainTest {
    public static void main(String[] args) {
        // Generate a test set of clients
        Client[] clients = generateTestClients(3);

        // Display the test set of clients
        displayClients(clients);

        // Load and display the Hashtable of accounts
        Hashtable<Integer, Account> accountHashtable = loadAccounts(clients);
        displayHashtableInAscendingOrder(accountHashtable);
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
}
