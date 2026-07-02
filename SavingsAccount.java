/**
 Demonstrate runtime polymorphism by creating a BankAccount reference and assigning it to objects of both SavingsAccount and CurrentAccount.
 Invoke the overridden methods through the parent class reference.
 */

package Bank;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(String bankAccountNumber, String bankCustomerName, double bankBalance) {
        super(bankAccountNumber, bankCustomerName, bankBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Amount credited: " + amount + "\n New Balance: " + this.balance);
        }
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        else  {
            this.balance -= amount;
            System.out.println("Amount Debited: " + amount + "\n New Balance: " + this.balance);
        }
    }
    public void displayAccount() {
        System.out.println("Savings Account Details:");
        System.out.println("Account Type: Savings Account");
        System.out.println("Current Balance: " + this.balance);
    }

}
