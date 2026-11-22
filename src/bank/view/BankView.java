/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.view;

/**
 *
 * @author natvi
 */

public class BankView {

    // Show the main menu
    public void showMenu() {
        System.out.println("\n=== BANK EMPLOYEE SYSTEM ===");
        System.out.println("1. Show employees");
        System.out.println("2. Search employee");
        System.out.println("3. Sort employees");
        System.out.println("4. Add records");
        System.out.println("5. Show binary tree");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    // Show messages to the user
    public void showMessage(String message) {
        System.out.println(message);
    }
}
