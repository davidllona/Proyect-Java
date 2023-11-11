package components;

import java.util.Date;

public class Debit extends Flow {
    public Debit(String comment, int identifier, double amount, int targetAccountNumber, boolean effect, Date date) {
        super(comment, identifier, amount, targetAccountNumber, effect, date);
    }

    @Override
    public String toString() {
        return "Debit: " + super.toString();
    }

    @Override
    public void updateAccountBalance(Account account) {
        // Logic to update account balance for a debit
    	account.setBalance(-getAmount(), "debit");
    }
}