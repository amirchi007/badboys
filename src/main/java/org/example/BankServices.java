package org.example;

import org.example.model.Account;

public class BankServices {
    public void transferMoney(Account from, Account to, double amount) throws IllegalArgumentException {
        if (from == null && to == null) {
            throw new IllegalArgumentException("Cannot transfer money from null account");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("money amount must be more than zero");
        }

        if (from.getBalance() < amount) {
            throw new IllegalArgumentException("Cannot transfer money from (from account) balance");
        }

        from.withdraw(amount);
        to.deposit(amount);
    };

}
