package com.pluralsight;


import java.util.Scanner;

public class Main {

    private static final Book[] Books = new Book[20];
    private static int BookInventory = 20;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        addInventory();

        System.out.println("Welcome to the neighborhood Library!");
        input.nextLine();

        boolean loopFlag = true;

        while (loopFlag) {
            mainScreenOptions();
            String UserChoice = mainScreenUserSelection();
            if (UserChoice.equalsIgnoreCase("E")) {
                printAllBooks();
                System.out.println("What Would you like to do next?");
            } else if (UserChoice.equalsIgnoreCase("A")) {
                printAllAvailableBooks();
            } else if (UserChoice.equalsIgnoreCase("N")) {
                printAllNonAvailableBooks();
            } else if (UserChoice.equalsIgnoreCase("C")) {
                checkInBook();
            } else if (UserChoice.equalsIgnoreCase("X")) {
                System.out.println("THANK YOU FOR VISITING NEIGHBORHOOD LIBRARY! SEE YOU SOON : )");
                loopFlag = !loopFlag;
            }
        }


    }


    public static void mainScreenOptions() {
        System.out.println("Please Select From The Following Options:");
        System.out.println("Enter (E) to see all books!");
        System.out.println("Enter (A) to see all books that are Available for checkout!");
        System.out.println("Enter (N) to see all books that are NOT Available for checkout!");
        System.out.println("Enter (C) to CheckIn a Borrowed Book!");
        System.out.println("Enter (X) to leave the library!");

    }

    public static String mainScreenUserSelection() {

        Scanner input = new Scanner(System.in);
        String UserChoice = input.nextLine();
        if (UserChoice.equalsIgnoreCase("E") || UserChoice.equalsIgnoreCase("A") || UserChoice.equalsIgnoreCase("N") ||
                UserChoice.equalsIgnoreCase("C") || UserChoice.equalsIgnoreCase("X")) {
            return UserChoice;
        } else {
            System.out.println("please select an option");
            mainScreenOptions();
        }
        return mainScreenUserSelection();
    }

    ;

    public static void printAllBooks() {

        System.out.println("These are all the books in the library:");
        for (int i = 0; i < Books.length; i++) {
            Book book = Books[i];
            int id = book.getId();
            String isbn = book.getIsbn();
            String title = book.getTitle();
            int availDays = book.getAvailableIn();
            String available = book.getAvailableIn() == 0 ? "You can checkout this book for 14 days" : "available for checkout in " + availDays + " days";
            System.out.println("id. " + id + " | " + "isbn" + "." + isbn + " | Title: " + title + " | " + available);

        }
        Scanner input = new Scanner(System.in);
        input.nextLine();

    }


    public static void printAllAvailableBooks() {

        System.out.println("Here are all the available books for checkout:");
        for (int i = 0; i < Books.length; i++) {
            Book book = Books[i];
            if (!book.isCheckedOut()) {
                int id = book.getId();
                String isbn = book.getIsbn();
                String title = book.getTitle();
                String available = book.getAvailableIn() == 0 ? "You can checkout this book for 14 days" : "not available for checkout yet! Will be Available in " + book.getAvailableIn() + "days";
                System.out.println("id. " + id + " | " + "isbn" + "." + isbn + " | Title: " + title + " | " + available);

            }
        }
        Scanner input = new Scanner(System.in);
        input.nextLine();

        System.out.println("Would you like to checkout a book?");
        System.out.println("Enter (Y) for YES or (N) for NO:");
        String userChoice = input.nextLine();


        if (userChoice.equalsIgnoreCase("Y")) {
            checkOutBook();
        } else if (userChoice.equalsIgnoreCase("N")) {
            System.out.println("Returning to MAIN MENU!");
        }


    }


    public static void printAllNonAvailableBooks() {

        System.out.println("Here are all the available books for checkout:");
        for (int i = 0; i < Books.length; i++) {
            if (Books[i].isCheckedOut()) {
                int id = Books[i].getId();
                String isbn = Books[i].getIsbn();
                String title = Books[i].getTitle();
                String available = Books[i].getAvailableIn() == 0 ? "You can checkout this book for 14 days" : "not available for checkout yet, it will be available in " + Books[i].getAvailableIn() + " days";
                System.out.println("id. " + id + " | " + "isbn" + "." + isbn + " | Title: " + title + " | " + available);

            }
        }
        Scanner input = new Scanner(System.in);
        input.nextLine();

    }



    public static void checkOutBook() {

        Scanner input = new Scanner(System.in);

        System.out.println("To check out a book, please enter your name:");
        String userName = input.next();
        input.nextLine();
        System.out.println("Nice to meet you " + userName + "!");
        System.out.println("Please Enter the Id of the book you would like to checkout:");
        int checkoutBook = input.nextInt();
        String bookName = "";
        for (int i = 0; i < Books.length; i++) {
            if (Books[i].getId() == checkoutBook) {
                Books[i].checkOut(userName);
                bookName = Books[i].getTitle();
            }
        }
        System.out.println("Success! Great you have checked out the book, " + bookName + " for 14 days!");
        input.nextLine();
        System.out.println("Returning to MAIN MENU----->");

    }

    public static void checkInBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("To check in a book, Please enter your name:");
        String userName = input.next();
        input.nextLine();
        System.out.println("Welcome back" + userName + "!");
        System.out.println("Please Enter the Id of the book you would like to check-In:");
        int checkoutBook = input.nextInt();
        String bookName = "";
        for (int i = 0; i < Books.length; i++) {
            if (Books[i].getId() == checkoutBook) {
                Books[i].checkIn();
                bookName = Books[i].getTitle();
            }
        }
        System.out.println("Success! Great you have checked out the book, " + bookName + "!");
        input.nextLine();
        System.out.println("Going Back to MAIN MENU----->");

    }


    private static void addInventory() {
        Books[0] = new Book(1001, "aaaa", "The Great Gatsby", false, "", 0);
        Books[1] = new Book(1002, "aaab", "The Prince and the Frog", true, "", 9);
        Books[2] = new Book(1003, "aaac", "Coda", false, "", 0);
        Books[3] = new Book(1004, "aaad", "Rose", true, "", 6);
        Books[4] = new Book(1005, "aaae", "She", false, "", 0);
        Books[5] = new Book(1006, "aaaf", "Da Vinci Code", true, "", 12);
        Books[6] = new Book(1007, "aaag", "The Alchemist", false, "", 0);
        Books[7] = new Book(1008, "aaah", "Dark Psychology and Gaslighting", true, "", 10);
        Books[8] = new Book(1009, "aaai", "The Holy Bible", false, "", 0);
        Books[9] = new Book(1010, "aaaj", "The Power Of Now", true, "", 11);
        Books[10] = new Book(1011, "aaak", "Holes", false, "", 0);
        Books[11] = new Book(1012, "aaal", "Bone", false, "", 0);
        Books[12] = new Book(1013, "aaam", "Cosmos", false, "", 0);
        Books[13] = new Book(1014, "aaan", "Kane and Abel", true, "", 7);
        Books[14] = new Book(1015, "aaao", "War And Peace", false, "", 0);
        Books[15] = new Book(1016, "aaap", "Blade Runner", false, "", 0);
        Books[16] = new Book(1017, "aaaq", "Hunter x Hunter", true, "", 3);
        Books[17] = new Book(1018, "aaar", "Hunger Games", false, "", 0);
        Books[18] = new Book(1019, "aaas", "Harry Potter", true, "", 13);
        Books[19] = new Book(1020, "aaat", "The Lightning Thief", true, "", 2);
    }

}