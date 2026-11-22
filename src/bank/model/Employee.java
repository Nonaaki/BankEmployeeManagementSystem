
package bank.model;

public class Employee {

    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private double salary;
    private String department;
    private String position;
    private String jobTitle;
    private String company;

    public Employee(String firstName, String lastName,
                    String gender, String email, double salary,
                    String department, String position,
                    String jobTitle, String company) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.jobTitle = jobTitle;
        this.company = company;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public String toFileString() {
        return firstName + "," + lastName + ","
                + gender + "," + email + ","
                + salary + "," + department + ","
                + position + "," + jobTitle + ","
                + company;
    }

    @Override
    public String toString() {
        return getFullName() + " | "
                + department + " | "
                + jobTitle;
    }
}
