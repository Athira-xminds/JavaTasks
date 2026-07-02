/**
 1.Create an enum Department with values HR,DEVELOPMENT,TESTING,SALES,FINANCE
 Create Employee class with variables

 id
 name
 department
 Methods
 Create multiple employees
 Display employee details
 Display employees department-wise
 */

import java.util.ArrayList;
import java.util.List;

public class Employee {
    enum Department {
        HR,
        DEVELOPMENT,
        TESTING,
        SALES,
        FINANCE;
    }

    // Instance variables
    String id;
    String name;
    Department department;

    // Constructor (Fixed: Assigned parameters to instance variables)
    public Employee(String id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Method to display individual employee details
    public void displayEmployeeDetails() {
        System.out.println("ID: " + id + "\nName: " + name + "\nDepartment: " + department);
    }
    public static void displayDepartmentWise(List<Employee> employeeList) {
        for (Department deptartment : Department.values()) {
            System.out.println("\nDepartment: " + deptartment);
            for (Employee emp : employeeList) {
                if (emp.department == deptartment) {
                    System.out.println("ID: " + emp.id + "\nName: " + emp.name);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("ABC123", "Ram", Department.DEVELOPMENT));
        employees.add(new Employee("ABC234", "Reghu", Department.FINANCE));
        employees.add(new Employee("ABC345", "George", Department.HR));
        employees.add(new Employee("ABC456", "James", Department.SALES));
        employees.add(new Employee("ABC567", "Lakshmi", Department.TESTING));
        employees.add(new Employee("ABC789", "Sita", Department.DEVELOPMENT));

        for (Employee employee : employees) {
            employee.displayEmployeeDetails();
        }
        displayDepartmentWise(employees);
        
    }
}

