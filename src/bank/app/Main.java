/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package bank.app;
/**
 *
 * @author natvi
 */


import bank.model.Employee;
import bank.service.FileService;
import bank.service.EmployeeService;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FileService fileService = new FileService();

        ArrayList<Employee> employees =
                fileService.readFile("Applicants_Form.txt");

        Scanner scanner = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();
        MenuOption option;

        do {
            System.out.println("\n=== BANK EMPLOYEE SYSTEM ===");
            System.out.println("1. Show employees");
            System.out.println("2. Search employee");
            System.out.println("3. Sort employees");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    option = MenuOption.SHOW_EMPLOYEES;
                    break;
                case "2":
                    option = MenuOption.SEARCH_EMPLOYEE;
                    break;
                case "3":
                    option = MenuOption.SORT_EMPLOYEES;
                    break;
                case "4":
                    option = MenuOption.EXIT;
                    break;
                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            switch (option) {
                case SHOW_EMPLOYEES:
                    for (Employee employee : employees) {
                        System.out.println(employee);
                    }
                    break;

                
                 case SEARCH_EMPLOYEE:
                  System.out.print("Enter employee full name: ");
                  String name = scanner.nextLine();

                  Employee found = employeeService.searchEmployee(
                   employees, name);

                 if (found != null) {
                 System.out.println("Employee found: " + found);
                } else {
                 System.out.println("Employee not found.");
                }
                 break;

                
                 case SORT_EMPLOYEES:
                 employeeService.sortEmployees(employees);

                 System.out.println("\nEmployees sorted alphabetically:");

                 for (Employee employee : employees) {
                 System.out.println(employee);
                }
                 break;


                case EXIT:
                    System.out.println("Goodbye!");
                    break;
            }

            if (option == MenuOption.EXIT) {
                break;
            }

        } while (true);

        scanner.close();
    }
}