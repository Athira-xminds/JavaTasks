//Create an interface named Transaction with the following methods:
//deposit(double amount)
//withdraw(double amount)
//Create an abstract class named BankAccount that implements the Transaction interface.

package Bank;

public interface Transaction {
    void deposit(double amount);
    void withdraw(double amount);
}