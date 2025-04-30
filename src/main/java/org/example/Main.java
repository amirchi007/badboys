package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // step one: variables
        Scanner scanner = new Scanner(System.in);
        double balance;
        boolean isRunning = true;
        int choice;

        // step two display menu
        System.out.println("______________");
        System.out.println("Welcome To ATM");
        System.out.println("______________");
        System.out.println("1. Show Balance");
        System.out.println("2. deposit");
        System.out.println("3. withdraw");
        System.out.println("3. Exit");
        System.out.println("______________");
        // getting input from user
        System.out.print("Enter The Options 1-2-3-4");
        choice = scanner.nextInt();

        // step three process user choice

//        bullshit way
//        while (choice == 1) {
//            System.out.println("Show Balance");
//        }
//        do {
//            System.out.println("deposit");
//        } while (choice == 2);
//        do {
//            System.out.println("withdraw");
//        } while (choice == 3);
//        do {
//            isRunning = false;
//        } while (choice == 4);
//        do {
//            System.out.println("Enter Valid numbers");
//        } while (choice != 1 && choice != 2 && choice != 3 && choice != 4);

        switch (choice) {
            case 1 -> System.out.println("show balance");
            case 2 -> System.out.println("deposit");
            case 3 -> System.out.println("withdraw");
            default -> System.out.println("Exit");
        }

        // last step: exit

        scanner.close();
    }
}