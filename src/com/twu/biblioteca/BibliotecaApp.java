package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    private static Menu menu = new Menu();
    private static String bookList;
    private static boolean appIsRunning = true;

    public static void main(String[] args) {
        displayWelcomeMessage();
        createBookList();
        menu.generateAppMenu();
        while(appIsRunning) {
            String userInput = menu.getUserInput();
            processUserInput(userInput);
        }
    }

    public static void displayWelcomeMessage () {
        System.out.print("\nWelcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n\n");
    }

    public static void processUserInput(String userInput) {
        switch (userInput) {
            case "1":
                System.out.print(bookList);
                break;
            default:
                System.out.print("\nPlease select a valid option\n\n");
                break;
       }
    }

    public static void createBookList() {
        ArrayList<Book> allBooks = new ArrayList<Book>();

        allBooks.add(new Book("His Dark Materials", "Philip Pullman", 1995));
        allBooks.add(new Book("Good Omens", "Neil Gaiman and Terry Pratchett", 1990));
        allBooks.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        allBooks.add(new Book("Neverwhere", "Neil Gaiman", 1996));
        allBooks.add(new Book("Earthsea Cycle", "Ursula K. Le Guin", 1968));
        allBooks.add(new Book("The Name of the Wind", "Patrick Rothfuss", 2007));
        allBooks.add(new Book("Harry Potter", "J.K. Rowling", 1997));

        String bookListString = "";
        for (Book book : allBooks) {
            bookListString += "\n" + book.getTitle() + " - " + book.getAuthor() + " - " + book.getPublicationYear();
        }
        bookListString += "\n\n";

        bookList = bookListString;
    }

}
