/**
 2.In an online Banking Login system User enters username and password.

 If password is incorrect throw InvalidPasswordException

 Allow only 3 attempts.After 3 attempts show message Account Locked
 */


import java.util.Scanner;

class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class OnlineBanking {
    static String CORRECT_USERNAME = "user123";
    static String CORRECT_PASSWORD = "Password123";
    static int MAX_ATTEMPTS = 3;

    public static void login(String username, String password) {
        if (!password.equals(CORRECT_PASSWORD)) {
            throw new InvalidPasswordException("Incorrect password entered.");
        }
        System.out.println("Login Successful.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            try {
                if (!username.equals(CORRECT_USERNAME)) {
                    System.out.println("Invalid username. Please try again.");
                    attempts++;
                    System.out.println("Remaining attempts: " + (MAX_ATTEMPTS - attempts));
                } else {
                    login(username, password);
                    break;
                }
            } catch (InvalidPasswordException e) {
                attempts++;
                System.out.println("Error: " + e.getMessage());
                System.out.println("Remaining attempts: " + (MAX_ATTEMPTS - attempts));
            } finally {
                System.out.println("Thank you.");
            }
            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Account Locked. Exceeded the maximum attempts.");
                break;
            }
        }
    }
}
