/**
 Create a class Nominee with:
 name
 Constructor
 Getter method
 Create a class Account with:
 accountHolderName
 Optional<Nominee> nominee
 Constructor
 Getter methods
 In the main() method:
 Create one account with a nominee.
 Create another account without a nominee using Optional.empty().
 Create a method displayNominee(Account account) that:
 Displays the account holder's name.
 Uses Optional.map() and orElse() to display:
 the nominee's name if present.
 "No Nominee registered" if no nominee exists.
 */

import java.util.Optional;
class Nominee {
    String name;

    public Nominee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Account {
    String accountHolderName;
    Optional<Nominee> nominee;
    public Account(String accountHolderName, Optional<Nominee> nominee) {
        this.accountHolderName = accountHolderName;
        this.nominee = nominee;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public Optional<Nominee> getNominee() {
        return nominee;
    }
}

public class BankingAccount {
    public static void displayNominee(Account account) {
        System.out.println("Account Holder: " + account.getAccountHolderName());
        String nomineeName = account.getNominee().map(Nominee::getName).orElse("No Nominee registered");
        System.out.println("Nominee: " + nomineeName);
    }

    public static void main(String[] args) {
        Nominee nominee1 = new Nominee("Nominee123");
        Account accountWithNominee = new Account("Ram", Optional.of(nominee1));
        Account accountWithoutNominee = new Account("Raj", Optional.empty());
        displayNominee(accountWithNominee);
        displayNominee(accountWithoutNominee);
    }
}
