/**Create Bank Account Management program create package bank and create
BankAccount Class
Variables
      accountNumber
      customerName
      balance
Constructors
        Default
        accountNumber only
        accountNumber + customerName + balance
Methods
        deposit(double amount)
        withdraw(double amount)
        displayBalance()
        displayAccount()
Method Overloading
        deposit(int amount)
        deposit(double amount)
        withdraw(int amount)
        withdraw(double amount)
Display an appropriate message if the balance is insufficient.*/

package Bank;
public class BankAccount implements Transaction {
    String accountNumber;
    String customerName;
    double balance;

    public BankAccount() {
    }

    public BankAccount(String bankAccountNumber) {
        accountNumber = bankAccountNumber;
    }

    public BankAccount(String bankAccountNumber, String bankCustomerName, double bankBalance) {
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
        if (amount < 0){
            System.out.println("Enter a valid amount");
        }
        else if (balance >= amount) {
            balance -= amount;
            System.out.println("Debited amount: " + amount);
        } else {
            System.out.println("Insufficient balance. Available balance " + balance);
        }
    }

    public void withdraw(int amount) {
        if (amount < 0){
            System.out.println("Enter a valid amount");
        }
        else if (balance >= amount) {
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
        BankAccount account1 = new BankAccount();
        account1.displayAccount();
        BankAccount account2 = new BankAccount("ABC99823");
        account2.displayAccount();
        BankAccount account3 = new BankAccount("ABC10293", "RAM", 500.00);
        BankAccount savingsaccount1 = new SavingsAccount("ABC123456","John",2500);
        BankAccount currentaccount1 = new CurrentAccount("ABC23456","Veena",3890);

        account3.displayAccount();
        account3.deposit(150);
        account3.deposit(25.75);
        account3.displayBalance();
        account3.withdraw(100);
        account3.withdraw(50.45);
        account3.displayBalance();
        account3.withdraw(10.00);
        account3.displayBalance();
        account3.withdraw(1000.00);
        account3.displayBalance();
        savingsaccount1.displayAccount();
        currentaccount1.displayAccount();
        savingsaccount1.deposit(250);
        currentaccount1.withdraw(100);
    }
}