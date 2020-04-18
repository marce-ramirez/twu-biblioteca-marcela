package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibliotecaApp {
    private static Menu menu = new Menu();
    public static ArrayList<Book> allBooks = new ArrayList<>();
    private static boolean appIsRunning = true;

    public static void main(String[] args) {
        displayWelcomeMessage();
        createBookList();
        menu.generateAppMenu();
        while(isAppRunning()) {
            String userInput = menu.getUserInput();
            if (userInput == null) {
                processUserInput("");
            } else {
                processUserInput(userInput);
            }
        }
    }

    public static boolean isAppRunning() {
        return appIsRunning;
    }

    public static void setAppNotRunning() {
        appIsRunning = false;
    }

    public static void displayWelcomeMessage () {
        System.out.print("\nWelcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
    }

    public static void processUserInput(String userInput) {
        switch (userInput) {
            case "1":
                displayBookList();
                break;
            case "2":
                checkoutBook();
                break;
            case "3":
                System.out.print("\nGood bye!\n\n");
                setAppNotRunning();
                break;
            default:
                System.out.print("\nPlease select a valid option\n");
                break;
       }
    }

    public static void createBookList() {
        allBooks.clear();
        allBooks.add(new Book("His Dark Materials", "Philip Pullman", 1995, "0892"));
        allBooks.add(new Book("Good Omens", "Neil Gaiman and Terry Pratchett", 1990, "0791"));
        allBooks.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "1603"));
        allBooks.add(new Book("Neverwhere", "Neil Gaiman", 1996, "0935"));
        allBooks.add(new Book("Earthsea Cycle", "Ursula K. Le Guin", 1968, "2448"));
        allBooks.add(new Book("The Name of the Wind", "Patrick Rothfuss", 2007, "3001"));
        allBooks.add(new Book("Harry Potter", "J.K. Rowling", 1997, "0204"));
    }

    private static void displayBookList() {
        StringBuilder bookList = new StringBuilder();
        for (Book book : allBooks) {
            if (book.isBookAvailable()) {
                bookList
                    .append("\n")
                    .append(book.getTitle())
                    .append(" | ")
                    .append(book.getAuthor())
                    .append(" | ")
                    .append(book.getPublicationYear())
                    .append(" | ID: ")
                    .append(book.getBookId());
            }
        }
        bookList.append("\n");
        System.out.print(bookList);
    }

    public static Book findBookById(String id) {
        for(Book book : allBooks) {
            if(book.getBookId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    private static void checkoutBook() {
        String bookId = null;
        System.out.print("Please enter the book ID: ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            bookId = is.readLine();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        Book foundBook = findBookById(bookId);
        if (foundBook != null) {
            foundBook.setBookNotAvailable();
        }
    }

}
