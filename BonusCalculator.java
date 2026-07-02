/**
 A company calculates bonuses differently for different departments.
 Define a functional interface Bonous Calculator
 with abstract method double calculateBonus(double salary);
 default method displayEmployee(String name)
 static method companyPolicy()
 Create lambda expressions for
 HR → 10%
 Developer → 20%
 Sales → 15%
 Tester → 12%
 */

@FunctionalInterface
public interface BonusCalculator {
    double calculateBonus(double salary);
    default void displayEmployee(String name) {
        System.out.println("Employee Name: " + name);
    }
    static void companyPolicy() {
        System.out.println("Company Policy---------------------");
    }
}
