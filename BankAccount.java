//Create Bank Account Management program create package bank and create
//BankAccount Class
//Variables
//      accountNumber
//      customerName
//      balance
//Constructors
//        Default
//        accountNumber only
//        accountNumber + customerName + balance
//Methods
//        deposit(double amount)
//        withdraw(double amount)
//        displayBalance()
//        displayAccount()
//Method Overloading
//        deposit(int amount)
//        deposit(double amount)
//        withdraw(int amount)
//        withdraw(double amount)
//Display an appropriate message if the balance is insufficient.

package Bank;

public class BankAccount {
    String accountNumber;
    String customerName;
    double balance;
    public BankAccount(){

    }
    public BankAccount(String bankAccountNumber){
        accountNumber = bankAccountNumber;
    }
    public BankAccount(String bankAccountNumber, String bankCustomerName, double bankBalance){
        accountNumber = bankAccountNumber;
        customerName = bankCustomerName;
        balance = bankBalance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Credited with: " + amount);
        } else {
            System.out.println("Enter a valid amount");
        }
    }
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Credited amount: " + amount);
        } else {
            System.out.println("Enter a valid amount");
        }
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Debited amount: " + amount);
        } else {
            System.out.println("Insufficient balance. Available balance " + balance);
        }
    }
    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Debited amount: " + amount);
        } else {
            System.out.println("Insufficient balance. Available balance " + balance);
        }
    }
    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber + "\n" + "Current Balance: " + balance);
    }
    public void displayAccount() {
        System.out.println("Account Information :");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Total Balance  : " + balance);
        System.out.println("\n");
    }
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();
        acc1.displayAccount();

        BankAccount acc2 = new BankAccount("ABC99823");
        acc2.displayAccount();

        BankAccount acc3 = new BankAccount("ABC10293", "RAM", 500.00);
        acc3.displayAccount();
        System.out.println("_________________________________________");
        acc3.deposit(150);
        acc3.deposit(25.50);
        acc3.displayBalance();
        System.out.println("_________________________________________");
        acc3.withdraw(100);
        acc3.withdraw(50.25);
        acc3.displayBalance();
        System.out.println("_________________________________________");
        acc3.withdraw(1000);
        acc3.displayBalance();
    }
}
