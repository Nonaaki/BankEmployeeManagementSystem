/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.service;

import bank.model.Employee;
import java.util.ArrayList;

/**
 *
 * @author natvi
 */
public class EmployeeService {

    public Employee searchEmployee(
            ArrayList<Employee> employees, String name) {

        for (Employee employee : employees) {

            if (employee.getFullName().equalsIgnoreCase(name)) {
                return employee;
            }
        }

        return null;
    }
    
public void sortEmployees(ArrayList<Employee> employees) {

    int n = employees.size();

    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {

            String name1 = employees.get(j).getFullName();
            String name2 = employees.get(j + 1).getFullName();

            if (name1.compareToIgnoreCase(name2) > 0) {

                Employee temp = employees.get(j);
                employees.set(j, employees.get(j + 1));
                employees.set(j + 1, temp);
            }
        }
    }
}

}