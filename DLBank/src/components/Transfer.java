package components;

import java.util.Date;

public class Transfer extends Flow {
    private int sourceAccountNumber;

    // Constructor calling the superclass constructor
    public Transfer(String comment, int identifier, double amount, int targetAccountNumber, boolean effect, Date date, int sourceAccountNumber) {
        super(comment, identifier, amount, targetAccountNumber, effect, date);
        this.sourceAccountNumber = sourceAccountNumber;
    }
    
    @Override
    public String toString() {
        return "Transfer from Account " + sourceAccountNumber + " to Account " + getTargetAccountNumber() + ": " + super.toString();
    }


    // Accessor for the additional attribute
    public int getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    // Mutator for the additional attribute
    public void setSourceAccountNumber(int sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    // Implementing the abstract method to update account balance
    @Override
    public void updateAccountBalance(Account account) {
        // Logic to update account balance for a transfer
        account.setBalance(-getAmount(), "transfer");
    }
}
