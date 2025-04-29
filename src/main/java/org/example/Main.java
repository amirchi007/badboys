package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // step one: variables
        Scanner scanner = new Scanner(System.in);
        double balance;
        boolean isRunning = true;
        int choice ;

        // step two display menu
        System.out.println("______________");
        System.out.println("Welcome To ATM");
        System.out.println("______________");
        System.out.println("1. Show Balance");
        System.out.println("2. deposit");
        System.out.println("3. withdraw");
        System.out.println("3. Exit");
        System.out.println("______________");

        // last step: exit

        scanner.close();
    }
}