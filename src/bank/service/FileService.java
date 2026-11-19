
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

public class FileService {

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
}
