//ATM Simulation
//
//Menu-driven application.
//
//        1 Deposit
//2 Withdraw
//3 Balance
//4 Mini Statement
//5 Exit
//
//Repeat using loops until Exit.

import java.util.ArrayList;
import java.util.Scanner;

public class ATMSimulation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        double balance = 0;
        int option = 0;
        ArrayList<String> statement = new ArrayList<>();
        while(option!= 5){

            System.out.println("ATM Simulation");
            System.out.println("..................................");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Choose any above option: ");
            int temp = sc.nextInt();
            option = temp;
            switch(option){
                case 1:
                    System.out.print("Enter the amount: ");
                    double deposit = sc.nextDouble();
                    if (deposit > 0){
                        balance += deposit;
                        System.out.println(deposit+" is credited to your account. Available balance is "+balance);
                        statement.add("deposited: "+deposit);
                    }

                    break;
                case 2:
                    System.out.print("Enter the amount:");
                    double withdraw = sc.nextDouble();
                    if (withdraw >0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println(withdraw + " is debited from your account. Available balance is " + balance);
                        statement.add("Withdrawn: "+withdraw);
                    }
                    else {
                        System.out.println("Insufficient balance");
                    }
                    break;
                case 3:
                    System.out.println("Available balance is "+balance);
                    break;
                case 4:
                    System.out.println("Statement");
                    for (String transaction : statement){
                        System.out.println(transaction);
                    }
                    break;
                case 5:
                    System.out.println("Thank you. Visit again");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}


