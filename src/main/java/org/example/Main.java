package org.example;

import org.example.model.Account;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // step one: variables
        Scanner scanner = new Scanner(System.in);

        Account ac1 = new Account(123, 456, "amir", 150.22);
        Account ac2 = new Account(456, 789, "ali", 385.36);

        double balance = 0;
        boolean isRunning = true;
        int choiceForAuth;
        int checkIdAndPassword;
        int choiceForBankService;

        boolean isUserLoggedIn = false;


        // step two display menu
        System.out.println("______________");
        System.out.println("Welcome To ATM");
        System.out.println("______________");
        System.out.println("1. Sign up Account");
        System.out.println("2. Sign In Account");
        System.out.print("Enter Your Choice : ");
        choiceForAuth = scanner.nextInt();
        if (choiceForAuth == 1) {
            System.out.print("Enter Your Name : ");
            String name = scanner.nextLine();
            System.out.println("Enter Your Account ID : ");
            int userId = scanner.nextInt();
            System.out.println("Enter Your Account Password : ");
            int password = scanner.nextInt();
            System.out.println("Enter Your Balance that You Want : ");
            double getBalance =  scanner.nextDouble();

            new Account(userId,password,name,getBalance);
        }
        if (choiceForAuth == 2) {
            System.out.print("Enter Your account ID and password: ");
            checkIdAndPassword = scanner.nextInt();
            if (ac2.checkIdAndPassword(checkIdAndPassword)){
                System.out.print("You Have Successfully Signed Up");
            };
        }

        switch (choiceForAuth) {
            case 1 -> {
                System.out.println("Welcome to BadBoys Bank");
                System.out.print("Enter Your Name : ");
                scanner.nextLine();
                System.out.print("Enter Your Balance that You Want : ");
                scanner.nextLine();
            }
            case 2 -> System.out.println("Enter Your Account ID And Password: ");
            default -> System.out.println("Invalid Option");
        }
        // getting input from user
        System.out.println("_______________________");
        System.out.println("Welcome to your account");
        System.out.println("_______________________");
        System.out.println("1. Show Balance");
        System.out.println("2. deposit");
        System.out.println("3. withdraw");
        System.out.println("3. Exit");
        System.out.print("Enter The Options 1-2-3-4 : ");
        choiceForBankService = scanner.nextInt();

        // step three process user choice


        switch (choiceForBankService) {
            case 1 -> showUserBalance(balance);
            case 2 -> System.out.println("deposit");
            case 3 -> System.out.println("withdraw");
            case 4 -> isRunning = false;
            default -> System.out.println("Invalid Option");
        }

        // step 4 show balance


        // last step: exit

        scanner.close();
    }

    static void showUserBalance(double balance) {
        System.out.println(balance);
    }
}