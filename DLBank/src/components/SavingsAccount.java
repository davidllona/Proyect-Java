package components;

public class SavingsAccount extends Account {
    // Constructor calling the superclass constructor
    public SavingsAccount(String label, Client client) {
        super(label, client);
    }

    @Override
    public void updateAccountBalance(Flow flow) {
        // Logic to update account balance for a savings account
        // You need to implement the logic based on your requirements
    }
}
