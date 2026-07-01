import java.util.Scanner;

public class DisplayPatterns {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the line count: ");
        int lineCount = sc.nextInt();
        sc.nextLine();
        for(int i=1; (i <= lineCount); i++){
            for (int j=1; j<=i; j++){
                System.out.print('*');
            }
            System.out.print("\n");
        }
    }
}
