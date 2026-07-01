//
//In a Library Management program create a string array to Store available books.
//        String[] books
//Operations
//Add books
//Search book
//Display books in upper case
//Count Books
//find book starting with specific word
//find book containing a specific word

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        String[] books = new String[20];
        int count = 0;
        while (option != 5) {
            System.out.println("Library Management System");
            System.out.println("---------------------------");
            System.out.println("1. Add books");
            System.out.println("2. Search book");
            System.out.println("3. Display books in upper case");
            System.out.println("4. Count Books");
            System.out.println("5. To check book name starts wIth certain word");
            System.out.println("6. To check book name contains certain word");
            System.out.println("7. Logout");
            System.out.print("Choose any above options: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {

                case 1:
                    System.out.print("Enter the book name to be added: ");
                    String addBook = sc.nextLine();
                    books[count] = addBook;
                    count++;
                    break;
                case 2:
                    System.out.print("Enter the book name to be searched: ");
                    String searchBook = sc.nextLine();
                    boolean isFound = false;
                    for (int i = 0; (i <= count-1); i++) {
                        if (books[i].equalsIgnoreCase(searchBook)) {
                            isFound = true;
                            break;
                        }
                    }
                    if (isFound) {
                            System.out.println("Book searched is found");
                        }
                    else{
                        System.out.println("Book searched is not found");
                    }
                    break;
                case 3:
                    System.out.println("Available Books");
                    for (int i = 0; (i <= count-1); i++) {
                        System.out.println(books[i].toUpperCase());
                    }
                    break;
                case 4:
                    System.out.println("Book count");
                    System.out.println("Number of books: " + (count));
                    break;
                case 5:
                    System.out.print("Enter a string :");
                    String startWord = sc.nextLine();
                    boolean isStartswith = false;
                    for (int i = 0; (i <= count-1); i++) {
                        if (books[i].startsWith(startWord)) {
                            System.out.println(books[i] +" starts with "+startWord);
                            isStartswith = true;
                        }
                    }
                    if(!isStartswith){
                        System.out.println("No book name startswith "+startWord);
                    }
                    break;
                case 6:
                    System.out.print("Enter a string :");
                    String word = sc.nextLine();
                    boolean isContains = false;
                    for (int i = 0; (i <= count-1); i++) {
                        if (books[i].contains(word)) {
                            System.out.println(books[i] +" contains "+word);
                            isContains = true;
                        }
                    }
                    if(!isContains){
                        System.out.println("No book name contains "+word);
                    }
                    break;
                case 7:
                    System.out.println("Thank you");
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}
