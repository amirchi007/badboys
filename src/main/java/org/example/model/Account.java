package org.example.model;

import org.example.exceptionHandler.AmountException;

public class Account {
    private final int accountId;
    private final int Password;
    private final String name;
    private double balance;

    public Account(int accountId, int accountPassword, String name, double balance) {
        this.accountId = accountId;
        this.Password = accountPassword;
        this.name = name;
        this.balance = balance;
    }

    public boolean checkIdAndPassword(int acNumberAndPassword) {
        boolean  signUpSuccessfully = false;
        if (acNumberAndPassword == accountId + Password){
             return signUpSuccessfully = true;
        }
        return signUpSuccessfully;
    };

    // getter (just of test)
    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public int getAccountId() {
        return accountId;
    }


//    public int getPassWord() {
//        return Password;
//    }

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
