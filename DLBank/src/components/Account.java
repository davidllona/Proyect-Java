package components;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected String label;
    protected double balance;
    protected int accountNumber;
    protected Client client;
    protected List<Flow> flows; // Maintain a list of flows for the account

    // Constructor with Label and a Client object as parameters and automatic assignment of the account number
    public Account(String label, Client client) {
        this.label = label;
        this.client = client;
        this.accountNumber = generateAccountNumber(); // Automatically assign the account number
        this.flows = new ArrayList<>(); // Initialize the list of flows
    }

    // Accessors (getters)
    protected String getLabel() {
        return label;
    }

    protected double getBalance() {
        return balance;
    }

    protected int getAccountNumber() {
        return accountNumber;
    }

    protected Client getClient() {
        return client;
    }

    // Mutators (setters)
    protected void setLabel(String label) {
        this.label = label;
    }

    protected void setBalance(double amount, String transactionType) {
        // Modify the balance based on the transaction type
        // Note: This is a placeholder, and you can customize the logic based on your requirements
        if ("transfer".equalsIgnoreCase(transactionType)) {
            // Logic for transfer
            this.balance -= amount;
        } else if ("credit".equalsIgnoreCase(transactionType)) {
            // Logic for credit
            this.balance += amount;
        } else if ("debit".equalsIgnoreCase(transactionType)) {
            // Logic for debit
            this.balance -= amount;
        } else {
            // Handle other transaction types as needed
        }
    }

    // Method to add a flow to the account
    public void addFlow(Flow flow) {
        flows.add(flow);
    }

    // toString() method to format the complete edition of the account
    @Override
    public String toString() {
        return "Account [Account Number: " + accountNumber + ", Label: " + label + ", Balance: " + balance +
                ", Client: " + client + "]";
    }

    // Static variable to automatically increment the account number
    private static int nextAccountNumber = 1;

    // Method to generate the next account number
    private static int generateAccountNumber() {
        return nextAccountNumber++;
    }
}
