package components;

import java.util.Date;

public abstract class Flow {
    private String comment;
    private int identifier;
    private double amount;
    private int targetAccountNumber;
    private boolean effect;
    private Date date;

    // Constructor
    public Flow(String comment, int identifier, double amount, int targetAccountNumber, boolean effect, Date date) {
        this.comment = comment;
        this.identifier = identifier;
        this.amount = amount;
        this.targetAccountNumber = targetAccountNumber;
        this.effect = effect;
        this.date = date;
    }

    // Accessors (getters)
    public String getComment() {
        return comment;
    }

    public int getIdentifier() {
        return identifier;
    }

    public double getAmount() {
        return amount;
    }

    public int getTargetAccountNumber() {
        return targetAccountNumber;
    }

    public boolean isEffect() {
        return effect;
    }

    public Date getDate() {
        return date;
    }

    // Mutators (setters)
    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTargetAccountNumber(int targetAccountNumber) {
        this.targetAccountNumber = targetAccountNumber;
    }

    public void setEffect(boolean effect) {
        this.effect = effect;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Abstract method to be implemented by subclasses
    public abstract void updateAccountBalance(Account account);
}
