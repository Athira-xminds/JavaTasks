/**
 Create a Student class with:
 id
 name
 email
 Print the email in uppercase.
 Handle the case where email is null using NullPointerException class
 */

import java.util.Scanner;

public class Student {
    String id;
    String name;
    String email;

    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        if (email.isEmpty() || !email.endsWith(".com")) {
            this.email = null;
        } else {
            this.email = email;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student's ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Student's name: ");
        String name = sc.nextLine();
        System.out.print("Enter the email id: ");
        String email = sc.nextLine();
        Student student = new Student(id, name, email);
        try {
            System.out.println("Student Name: " + student.name);
            System.out.println("Email in uppercase: " + student.email.toUpperCase());

        } catch (NullPointerException e) {
            System.out.println("Error: Provided email is invalid");
        }
    }
}

