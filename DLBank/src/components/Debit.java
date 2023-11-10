package components;

import java.util.Date;

public class Debit extends Flow {
    // Constructor calling the superclass constructor
    public Debit(String comment, int identifier, double amount, int targetAccountNumber, boolean effect, Date date) {
        super(comment, identifier, amount, targetAccountNumber, effect, date);
    }
}