package components;

public abstract class Account {
    protected String label;
    protected double balance;
    protected int accountNumber;
    protected Client client;

    // Constructor with Label and a Client object as parameters and automatic assignment of the account number
    public Account(String label, Client client) {
        this.label = label;
        this.client = client;
        this.accountNumber = nextAccountNumber++;
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
        if ("transfer".equalsIgnoreCase(transactionType)) {
            // Logic for transfer
        } else if ("credit".equalsIgnoreCase(transactionType)) {
            // Logic for credit
        } else if ("debit".equalsIgnoreCase(transactionType)) {
            // Logic for debit
        } else {
            // Handle other transaction types as needed
        }
    }

    // toString() method to format the complete edition of the account
    @Override
    public String toString() {
        return "Account [Account Number: " + accountNumber + ", Label: " + label + ", Balance: " + balance +
               ", Client: " + client + "]";
    }

    // Static variable to automatically increment the account number
    private static int nextAccountNumber = 1;
}
