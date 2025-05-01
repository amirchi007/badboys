package org.example.model;

import org.example.exceptionHandler.AmountException;

public class Account {
    private final int accountId;
    private final int password;
    private final String name;
    private double balance;

    public Account(int accountId, int password, String name, double balance) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.balance = balance;
    }

    public boolean checkIdAndPassword(int id, int pass) {
        return this.accountId == id && this.password == pass;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public int getAccountId() {
        return accountId;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new AmountException();
        }
        balance -= amount;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new AmountException();
        }
        balance += amount;
    }

    public void transferMoney(Account to, double amount) {
        if (to == null || to == this || amount <= 0 || amount > this.balance) {
            throw new AmountException();
        }
        this.withdraw(amount);
        to.deposit(amount);
    }
}
