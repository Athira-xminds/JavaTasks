import java.util.Scanner;

public class Calculation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        System.out.println("Addition :-" );
        System.out.println(num1+" + "+num2+" = "+ (num1+num2));
        System.out.println("Subtraction :- ");
        System.out.println(num1+" - "+num2+" = "+ (num1 - num2));
        System.out.println("Multiplication :-");
        System.out.println(num1+" * "+num2+" = "+ (num1 * num2));
        if (num2 != 0) {
            System.out.println("Division :- ");
            System.out.println(num1+" / "+num2+" = "+ (num1 / num2));
            System.out.println("Modulus :- ");
            System.out.println(num1+" % "+num2+" = "+ (num1 % num2));
        } else {
            System.out.println("Can't perform division and modulus division by 0" );
        }
    }
}
