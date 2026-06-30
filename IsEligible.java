import java.util.Scanner;

public class IsEligible {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the mark: ");
        double mark = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter the attendence: ");
        double attendance = sc.nextDouble();
        sc.nextLine();

        if ((mark > 70) && (attendance > 75)) {
            System.out.print("Student is eligible for higher studies");
        }
        else{
            System.out.print("Student is not eligible for higher studies");
        }

    }
}

