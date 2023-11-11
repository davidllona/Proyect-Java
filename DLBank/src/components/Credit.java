package components;

import java.util.Date;

public class Credit extends Flow {
    public Credit(String comment, int identifier, double amount, int targetAccountNumber, boolean effect, Date date) {
        super(comment, identifier, amount, targetAccountNumber, effect, date);
    }

    @Override
    public String toString() {
        return "Credit: " + super.toString();
    }

    @Override
    public void updateAccountBalance(Account account) {
        // Logic to update account balance for a credit
        account.setBalance(getAmount(), "credit");
    }
}