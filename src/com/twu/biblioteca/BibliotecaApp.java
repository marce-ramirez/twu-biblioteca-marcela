package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    private static Menu menu = new Menu();
    public static ArrayList<Book> allBooks = new ArrayList<>();
    private static String bookList;
    private static boolean appIsRunning = true;

    public static void main(String[] args) {
        displayWelcomeMessage();
        createBookList();
        menu.generateAppMenu();
        while(isAppRunning()) {
            String userInput = menu.getUserInput();
            processUserInput(userInput);
        }
    }

    public static boolean isAppRunning() {
        return appIsRunning;
    }

    public static void setAppNotRunning() {
        appIsRunning = false;
    }

    public static void displayWelcomeMessage () {
        System.out.print("\nWelcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n\n");
    }

    public static void processUserInput(String userInput) {
        switch (userInput) {
            case "1":
                displayBookList();
                break;
            case "2":
                System.out.print("\nGood bye!\n");
                setAppNotRunning();
                break;
            default:
                System.out.print("\nPlease select a valid option\n\n");
                break;
       }
    }

    private static void displayBookList() {
        bookList = "";
        for (Book book : allBooks) {
            bookList += "\n" + book.getTitle() + " | " + book.getAuthor() + " | " +  book.getPublicationYear() + " | ID: " + book.getBookId();
        }
        bookList += "\n\n";
        System.out.print(bookList);
    }

    public static void createBookList() {
        allBooks.add(new Book("His Dark Materials", "Philip Pullman", 1995, "0892"));
        allBooks.add(new Book("Good Omens", "Neil Gaiman and Terry Pratchett", 1990, "0791"));
        allBooks.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "1603"));
        allBooks.add(new Book("Neverwhere", "Neil Gaiman", 1996, "0935"));
        allBooks.add(new Book("Earthsea Cycle", "Ursula K. Le Guin", 1968, "2448"));
        allBooks.add(new Book("The Name of the Wind", "Patrick Rothfuss", 2007, "3001"));
        allBooks.add(new Book("Harry Potter", "J.K. Rowling", 1997, "0204"));
    }
}
