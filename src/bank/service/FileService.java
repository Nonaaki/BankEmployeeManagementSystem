
package bank.service;

/**
 *
 * @author natvi
 */

import bank.model.Employee;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

public class FileService {

    // Read employees from file
    public ArrayList<Employee> readFile(String filename) {

        ArrayList<Employee> employees = new ArrayList<>();

        try (BufferedReader reader =
                new BufferedReader(new FileReader(filename))) {

            String line;

            // Skip the header
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length != 9) {
                    System.out.println("Invalid row: " + line);
                    continue;
                }

                try {
                    String firstName = data[0].trim();
                    String lastName = data[1].trim();
                    String gender = data[2].trim();
                    String email = data[3].trim();

                    double salary =
                            Double.parseDouble(data[4].trim());

                    if (!Double.isFinite(salary) || salary < 0) {
                        System.out.println("Invalid salary: " + line);
                        continue;
                    }

                    String department = data[5].trim();
                    String position = data[6].trim();
                    String jobTitle = data[7].trim();
                    String company = data[8].trim();

                    Employee employee = new Employee(
                            firstName, lastName, gender,
                            email, salary, department,
                            position, jobTitle, company
                    );

                    employees.add(employee);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid salary: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println(
                    "Error reading file: " + e.getMessage());
        }

        return employees;
    }

    // Save a new employee to file
    public boolean addRecord(String filename, Employee employee) {

        File file = new File(filename);

        if (!file.isFile()) {
            System.out.println("Employee file not found.");
            return false;
        }

        try {
            boolean needsNewLine = file.length() > 0;

            if (needsNewLine) {
                try (java.io.RandomAccessFile check =
                        new java.io.RandomAccessFile(file, "r")) {

                    check.seek(file.length() - 1);
                    int last = check.read();
                    needsNewLine = last != '\n' && last != '\r';
                }
            }

            try (BufferedWriter writer =
                    new BufferedWriter(new FileWriter(file, true))) {

                if (needsNewLine) {
                    writer.newLine();
                }

                writer.write(employee.toFileString());
                writer.newLine();
            }

            return true;

        } catch (IOException e) {
            System.out.println(
                    "Error saving employee: " + e.getMessage());
            return false;
        }
    }
}



