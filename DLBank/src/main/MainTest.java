package main;


import components.Account;
import components.Client;
import components.CurrentAccount;
import components.SavingsAccount;



public class MainTest {
	public static void main(String[] args) {
        // Generate a test set of clients
        Client[] clients = generateTestClients(3);

        // Display the test set of clients
        displayClients(clients);

        // Load and display the table of accounts
        Account[] accounts = loadAccounts(clients);
        displayAccounts(accounts);
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

    private static Account[] loadAccounts(Client[] clients) {
        // Create a list to store the accounts
        java.util.List<Account> accountList = new java.util.ArrayList<>();

        // Generate a savings account and a current account per client with zero balances
        for (Client client : clients) {
            SavingsAccount savingsAccount = new SavingsAccount("Savings Account", client);
            CurrentAccount currentAccount = new CurrentAccount("Current Account", client);

            accountList.add(savingsAccount);
            accountList.add(currentAccount);
        }

        // Convert the list to an array and return
        return accountList.toArray(new Account[0]);
    }

    private static void displayAccounts(Account[] accounts) {
        // Display the contents of the array of accounts using a stream
        System.out.println("Table of Accounts:");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}


