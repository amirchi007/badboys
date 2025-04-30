package org.example.model;

import org.example.AmountException;

public class Account {
    private int accountNumber;
    private String name;
    private double balance;

    public Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    // getter (just of test)
    public double getBalance() {
        return balance;
    }

    // get money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // send money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void transferMoney(Account from, Account to, double amount) {
        if (amount > 0 && amount <= balance) {
            from.withdraw(amount);
            to.deposit(amount);
        } else {
            throw new AmountException();
        }
    }


}
