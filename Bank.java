/**
 A bank receives different types of customer requests such as deposits, withdrawals, balance inquiries, money transfers, statement printing, and mobile number updates.
 Instead of creating a new thread for every request, the bank uses a thread pool of three worker threads. Each available thread processes one transaction at a time. Once a transaction is completed, the thread is reused to process another waiting transaction.
 Write a Java program to simulate this scenario using ExecutorService.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
class BankTransaction implements Runnable {
    String customerName;
    String transactionType;

    public BankTransaction(String customerName, String transactionType) {
        this.customerName = customerName;
        this.transactionType = transactionType;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started processing. " + transactionType + " for " + customerName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        ExecutorService bankService = Executors.newFixedThreadPool(3);
        BankTransaction[] transactions = {
                new BankTransaction("customer1", "Deposit"),
                new BankTransaction("customer2", "Withdrawal"),
                new BankTransaction("customer3", "Balance Inquiry"),
                new BankTransaction("customer4", "Money Transfer"),
                new BankTransaction("customer5", "Statement Printing"),
                new BankTransaction("customer6", "Mobile Number Update")
        };
        for (BankTransaction transaction : transactions) {
            bankService.execute(transaction);
        }
        bankService.shutdown();
    }
}
