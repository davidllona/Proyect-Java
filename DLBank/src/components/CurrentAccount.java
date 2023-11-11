package components;

public class CurrentAccount extends Account {
    // Constructor calling the superclass constructor
    public CurrentAccount(String label, Client client) {
        super(label, client);
    }

    @Override
    public void updateAccountBalance(Flow flow) {
        // Logic to update account balance for a current account
        // You need to implement the logic based on your requirements
    }
}
