package Bank;

public class CurrentAccount extends BankAccount {

    public CurrentAccount(String bankAccountNumber, String bankCustomerName, double bankBalance) {
        super(bankAccountNumber, bankCustomerName, bankBalance);
    }
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Amount Credited" + amount + " \n New Balance: " + this.balance );
        }
    }
    public void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Invalid withdrawal amount.");
        }
        else if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Amount debited " + amount + " \n New Balance: " + this.balance);
        }
        else {
            System.out.println("Insufficient  in your current account. Available balance " + balance);
        }
    }
    public void displayAccount() {
        System.out.println("Current Account Details:");
        System.out.println("Account Type: Current Account");
        System.out.println("Current Balance: " + this.balance);
    }
}
