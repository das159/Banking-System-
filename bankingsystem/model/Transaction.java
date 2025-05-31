package bankingsystem.model;

import java.time.LocalDateTime;

public class Transaction {
    private String accountNumber;
    private String type; // Deposit or Withdraw
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(String accountNumber, String type, double amount) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "[" + dateTime + "] " + type + " $" + amount + " for Account " + accountNumber;
    }
}
