package org.example;

import org.example.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //
    static Scanner scanner = new Scanner(System.in);
    static List<Account> accounts = new ArrayList<>();
    static Account currentUser = null;

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("______________");
            System.out.println("Welcome To ATM");
            System.out.println("______________");
            System.out.println("1. Sign Up Account");
            System.out.println("2. Sign In Account");
            System.out.println("3. Exit");
            System.out.print("Enter Your Choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> signUp();
                case 2 -> {
                    if (signIn()) {
                        showBankMenu();
                    }
                }
                case 3 -> {
                    System.out.println("Thanks for using ATM");
                    isRunning = false;
                }
                default -> System.out.println("Invalid option");
            }
        }

        scanner.close();
    }

    private static void signUp() {
        System.out.print("Enter Your Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Your Account ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Your Password: ");
        int password = scanner.nextInt();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();

        Account account = new Account(id, password, name, balance);
        accounts.add(account);
        System.out.println("Account Created Successfully! Plase Sign In.");
    }

    private static boolean signIn() {
        System.out.print("Enter Your Account ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Your Password: ");
        int password = scanner.nextInt();

        for (Account acc : accounts) {
            if (acc.checkIdAndPassword(id, password)) {
                currentUser = acc;
                System.out.println("Login Successfuly" + acc.getName());
                return true;
            }
        }

        System.out.println("Invalid Input");
        return false;
    }

    private static void showBankMenu() {
        // for logout
        boolean inSession = true;

        while (inSession) {
            System.out.println("_______________");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Money");
            System.out.println("5. Logout");
            System.out.print("Enter Your Choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Your balance: " + currentUser.getBalance());
                case 2 -> {
                    System.out.print("Enter amount to deposit: ");
                    double amount = scanner.nextDouble();

                    currentUser.deposit(amount);

                    System.out.println("Deposit successful!");
                }
                case 3 -> {
                    System.out.print("Enter amount to withdraw: ");
                    double amount = scanner.nextDouble();

                    currentUser.withdraw(amount);

                    System.out.println("Withdrawal successful");
                }
                case 4 -> {
                    System.out.print("Enter Purpose Account ID: ");
                    int targetId = scanner.nextInt();
                    System.out.print("Enter amount that you want to transfer: ");
                    double amount = scanner.nextDouble();
                    Account receiver = findAccountById(targetId);

                    if (receiver == null) {
                        System.out.println("Receiver account didnt found!");
                    }
                    currentUser.transferMoney(receiver, amount);
                    System.out.println("Transfer successful!");

                }
                case 5 -> {
                    currentUser = null;
                    inSession = false;
                    System.out.println("Logged out.");
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // go find account by id in console
    private static Account findAccountById(int id) {
        for (Account acc : accounts) {
            if (acc.getAccountId() == id) return acc;
        }
        return null;
    }
}
