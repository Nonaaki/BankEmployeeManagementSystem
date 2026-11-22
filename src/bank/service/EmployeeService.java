/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package bank.service;

import bank.model.Employee;
import java.util.ArrayList;

public class EmployeeService {

    // Recursive Binary Search
    public Employee searchEmployee(ArrayList<Employee> employees, String name) {
        sortEmployees(employees);
        return binarySearch(employees, name.trim(), 0, employees.size() - 1);
    }

    private Employee binarySearch(ArrayList<Employee> employees,
                                  String name, int left, int right) {

        if (left > right) {
            return null;
        }

        int middle = left + (right - left) / 2;

        Employee employee = employees.get(middle);
        int comparison = employee.getFullName().compareToIgnoreCase(name);

        if (comparison == 0) {
            return employee;
        }

        if (comparison > 0) {
            return binarySearch(employees, name, left, middle - 1);
        }

        return binarySearch(employees, name, middle + 1, right);
    }

    // Recursive Merge Sort
    public void sortEmployees(ArrayList<Employee> employees) {
        if (employees.size() > 1) {
            mergeSort(employees, 0, employees.size() - 1);
        }
    }

    private void mergeSort(ArrayList<Employee> employees,
                           int left, int right) {

        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;

        mergeSort(employees, left, middle);
        mergeSort(employees, middle + 1, right);

        merge(employees, left, middle, right);
    }

    private void merge(ArrayList<Employee> employees,
                       int left, int middle, int right) {

        ArrayList<Employee> temp = new ArrayList<>();

        int i = left;
        int j = middle + 1;

        while (i <= middle && j <= right) {

            String name1 = employees.get(i).getFullName();
            String name2 = employees.get(j).getFullName();

            if (name1.compareToIgnoreCase(name2) <= 0) {
                temp.add(employees.get(i++));
            } else {
                temp.add(employees.get(j++));
            }
        }

        while (i <= middle) {
            temp.add(employees.get(i++));
        }

        while (j <= right) {
            temp.add(employees.get(j++));
        }

        for (int k = 0; k < temp.size(); k++) {
            employees.set(left + k, temp.get(k));
        }
    }
}
