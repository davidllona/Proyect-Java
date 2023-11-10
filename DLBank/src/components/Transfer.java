package components;

import java.util.Date;

public class Transfer extends Flow {
    private int sourceAccountNumber;

    // Constructor calling the superclass constructor
    public Transfer(String comment, int identifier, double amount, int targetAccountNumber, boolean effect, Date date, int sourceAccountNumber) {
        super(comment, identifier, amount, targetAccountNumber, effect, date);
        this.sourceAccountNumber = sourceAccountNumber;
    }

    // Accessor for the additional attribute
    public int getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    // Mutator for the additional attribute
    public void setSourceAccountNumber(int sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }
}