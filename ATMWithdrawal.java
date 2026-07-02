/**
 A customer withdraws money from an ATM.
 Requirements
 Accept withdrawal amount.
 Throw an exception if:
 withdrawal amount is negative.
 withdrawal amount is greater than balance.
 Use:
 try
 catch
 finally
 */


import java.util.Scanner;

public class ATMWithdrawal {
    static double accountBalance = 1500.00;

    public static void Withdrawal(double amount) throws Exception {
        if (amount < 0) {
            throw new Exception("Withdrawal amount cannot be negative.");
        }
        if (amount > accountBalance) {
            throw new Exception("Insufficient funds. You cannot withdraw more than your balance.");
        }

        accountBalance -= amount;
        System.out.println("Please collect your cash: " + amount);
        System.out.println("Available Balance: " + accountBalance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Current Available Balance: " + accountBalance);
        System.out.print("Enter the amount you wish to withdraw: ");

        try {
            double withdrawalAmount = scanner.nextDouble();
            Withdrawal(withdrawalAmount);
        } catch (Exception e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        } finally {
            System.out.println("Thank you. Visit again.");
            scanner.close();
        }
    }
}

