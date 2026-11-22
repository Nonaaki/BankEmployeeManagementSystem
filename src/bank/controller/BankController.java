/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package bank.controller;


/**
 *
 * @author natvi
 */

import bank.model.Employee;
import bank.model.EmployeeTree;
import bank.service.FileService;
import bank.service.EmployeeService;
import java.util.ArrayList;
import java.util.Scanner;
import bank.view.BankView;
import bank.app.MenuOption;

public class BankController {

    public void run() {
        String filename = "Applicants_Form.txt";

        FileService fileService = new FileService();
        BankView view = new BankView();

        ArrayList<Employee> employees =
                fileService.readFile(filename);

        Scanner scanner = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();

        MenuOption option;

        do {
            view.showMenu();
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
                    option = MenuOption.ADD_RECORDS;
                    break;
                case "5":
                    option = MenuOption.SHOW_TREE;
                    break;
                case "6":
                    option = MenuOption.EXIT;
                    break;
                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            switch (option) {

                case SHOW_EMPLOYEES:

                    if (employees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        for (Employee employee : employees) {
                            System.out.println(employee);
                        }
                    }
                    break;

                case SEARCH_EMPLOYEE:

                    System.out.print("Enter employee full name: ");
                    String name = scanner.nextLine();

                    Employee found =
                            employeeService.searchEmployee(
                                    employees, name);

                    if (found != null) {
                        System.out.println("Employee found: " + found);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case SORT_EMPLOYEES:

                    employeeService.sortEmployees(employees);

                    System.out.println("\nFirst 20 employees:");

                    int limit = Math.min(20, employees.size());

                    for (int i = 0; i < limit; i++) {
                        System.out.println(employees.get(i));
                    }
                    break;

                case ADD_RECORDS:

                    System.out.println("\n=== ADD NEW EMPLOYEE ===");

                    System.out.print("First name: ");
                    String firstName = scanner.nextLine().trim();

                    System.out.print("Last name: ");
                    String lastName = scanner.nextLine().trim();

                    System.out.print("Gender: ");
                    String gender = scanner.nextLine().trim();

                    System.out.print("Email: ");
                    String email = scanner.nextLine().trim();

                    System.out.print("Salary: ");
                    String salaryInput = scanner.nextLine().trim();

                    System.out.print("Department: ");
                    String department = scanner.nextLine().trim();

                    System.out.print("Position: ");
                    String position = scanner.nextLine().trim();

                    System.out.print("Job title: ");
                    String jobTitle = scanner.nextLine().trim();

                    System.out.print("Company: ");
                    String company = scanner.nextLine().trim();

                    String[] fields = {
                        firstName, lastName, gender, email,
                        salaryInput, department, position,
                        jobTitle, company
                    };

                    boolean valid = true;

                    for (String field : fields) {
                        if (field.isEmpty() || field.contains(",")
                                || field.contains("\n")
                                || field.contains("\r")) {
                            valid = false;
                            break;
                        }
                    }

                    if (!valid) {
                        System.out.println("Invalid employee details.");
                        break;
                    }

                    double salary;

                    try {
                        salary = Double.parseDouble(salaryInput);

                        if (!Double.isFinite(salary) || salary < 0) {
                            System.out.println("Invalid salary.");
                            break;
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary.");
                        break;
                    }

                    Employee newEmployee = new Employee(
                            firstName, lastName, gender,
                            email, salary, department,
                            position, jobTitle, company
                    );

                    if (fileService.addRecord(filename, newEmployee)) {
                        employees.add(newEmployee);
                        System.out.println("Employee added successfully!");
                    }
                    break;

                case SHOW_TREE:

                    EmployeeTree tree = new EmployeeTree();

                    int total = Math.min(20, employees.size());

                    for (int i = 0; i < total; i++) {
                        tree.insert(employees.get(i));
                    }

                    System.out.println("\n=== BINARY SEARCH TREE ===");

                    tree.levelOrder();

                    System.out.println(
                            "\nTotal nodes: " + tree.countNodes());

                    System.out.println(
                            "Tree height: " + tree.getHeight());

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
