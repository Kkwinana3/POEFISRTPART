/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poefisrtpart;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class POEFISRTPART {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String username;
        String password;
        String cellphone;

        System.out.println("Enter your username: ");
        username = scanner.nextLine();
        while (!validateUsername(username)) {
            System.out.println("Re-enter your username: ");
            username = scanner.nextLine();
        }


        System.out.print("Enter your password: ");
        password = scanner.nextLine();
        while (!validatePassword(password)) {
            System.out.println("Re-enter your password: ");
            password = scanner.nextLine();
        }

        System.out.println("Enter your cellphone number: ");
        cellphone = scanner.nextLine();
        while (!validateCellphone(cellphone)) {
            System.out.println("Re-enter your cellphone number: ");
            cellphone = scanner.nextLine();
        }   

        scanner.close();
    
    }
    
    //username and password validation
    public static boolean validateUsername(String name) {
        if (name.length() < 5 && !name.contains("_")) {
            System.out.println("Username must be at least 5 characters long and contain an underscore.");
            return false;
        } else {
            System.out.println("Username successfully captured.");
        }
        return true;
    }

    public static boolean validatePassword(String password) {
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        } else if (!password.matches(".*[A-Z].*")) {
            System.out.println("Password must contain at least one uppercase letter.");
            return false;
        } else if (!password.matches(".*[0-9].*")) {
            System.out.println("Password must contain at least one number.");
            return false;
        } else if (!password.matches(".*[!@#$%^&*()].*")) {
            System.out.println("Password must contain at least one special character.");
            return false;
        } else {
            System.out.println("Password successfully captured.");
        }
        return true;
    }

    //cellphone number validation
    public static boolean validateCellphone(String cellphone) {
        if (!cellphone.matches("^\\+27\\d{9}$")) {
            System.out.println("Cellphone number must be in the format +27 followed by 9 digits.");
            return false;
        } else {
            System.out.println("Cellphone number successfully captured.");
            return true;
        }   
    }
}
