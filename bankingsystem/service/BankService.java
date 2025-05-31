package bankingsystem.service;

import bankingsystem.model.Account;
import bankingsystem.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BankService {
    private List<Account> accounts = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    public void createAccount(String accNum, String owner) {
        accounts.add(new Account(accNum, owner));
    }

    public Account findAccount(String accNum) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accNum)) return acc;
        }
        return null;
    }

    public boolean deposit(String accNum, double amount) {
        Account acc = findAccount(accNum);
        if (acc != null && amount > 0) {
            acc.deposit(amount);
            transactions.add(new Transaction(accNum, "Deposit", amount));
            return true;
        }
        return false;
    }

    public boolean withdraw(String accNum, double amount) {
        Account acc = findAccount(accNum);
        if (acc != null && amount > 0 && acc.withdraw(amount)) {
            transactions.add(new Transaction(accNum, "Withdraw", amount));
            return true;
        }
        return false;
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }
}
