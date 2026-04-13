/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poefisrtpart;

/**
 *
 * @author Student
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Loginclass {
    private String username;
    private String password;
    // this ArrayList is there store registered users so that we can check against it when a user tries to log in. I made it static so that it can be accessed without needing an instance/object of Login.
    private static ArrayList<Loginclass> registeredUsers = new ArrayList<>();

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean loginUser() {
        for (Registration user : registeredUsers) {
            
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Login System");
        // Main loop to display the menu and handle user input.
        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    handleRegistration(scanner);
                    break;
                case "2":
                    handleLogin(scanner);
                    break;
                case "3":
                case "exit":
                    System.out.println("Exiting the system. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
        scanner.close();// Closing the scanner to prevent resource leaks.
    }

    // Method to handle user registration. It prompts the user for their name, cell phone number, and password, and validates each input using the static methods from the Registration class. If all inputs are valid, it creates a new Registration object and adds it to the registeredUsers list.
    // reason for having the scanner passed as a parameter is to avoid creating multiple Scanner instances which can lead to resource leaks and other issues. By passing the same Scanner instance, we ensure that we are using a single input stream for all user interactions throughout the program.
    private static void handleRegistration(Scanner scanner) {
        System.out.println("\n--- Registration ---");
        
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        while (!Registration.checkUsername(name)) {
            name = scanner.nextLine();
        }

        System.out.println("Enter your cell phone number (format: +27XXXXXXXXX):");
        String cell = scanner.nextLine();
        while (!Registration.checkCellPhoneNumber(cell)) {
            cell = scanner.nextLine();
        }

        System.out.println("Create a password:");
        String pass = scanner.nextLine();
        while (!Registration.checkPasswordComplexity(pass)) {
            pass = scanner.nextLine();
        }

        Registration newUser = new Registration(name, cell, pass);
        registeredUsers.add(newUser);
        System.out.println("Registration successful! You can now log in from the main menu.");
    }
    // Method to handle user login. It prompts the user for their username and password, and checks if the credentials match any of the registered users in the registeredUsers list. If a match is found, it prints a welcome message; otherwise, it informs the user that the login failed.
    //same reason for passing the scanner as a parameter as explained in the handleRegistration method.
    private static void handleLogin(Scanner scanner) {
        if (Loginclass.isEmpty()) {
            System.out.println("No users registered yet. Please register first.");
            return;
        }

        System.out.println("\n--- Login ---");
        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        Loginclass attempt = new Loginclass(user, pass);
        if (attempt.loginUser()) {
            System.out.println("Login successful! Welcome, " + user + ".");
            
        } else {
            System.out.println("Login failed. Invalid credentials.");
        }
    }
}
