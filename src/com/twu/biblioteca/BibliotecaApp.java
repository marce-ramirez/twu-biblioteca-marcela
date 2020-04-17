package com.twu.biblioteca;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class BibliotecaApp {
    private static ArrayList<Book> allBooks = new ArrayList<Book>();
    private static Menu menu = new Menu();
    private static String userInput;

    public static void main(String[] args) {
        displayWelcomeMessage();
        menu.generateAppMenu();
        processUserInput();
    }

    public static void displayWelcomeMessage () {
        System.out.print("\nWelcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n\n");
    }

    public static void processUserInput() {
        userInput = menu.getUserInput();
        switch (userInput) {
            case "1":
                displayBooksList();
                break;
            default:
                break;
       }
    }

    public static void createBookList() {
        allBooks.add(new Book("His Dark Materials", "Philip Pullman", 1995));
        allBooks.add(new Book("Good Omens", "Neil Gaiman and Terry Pratchett", 1990));
        allBooks.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        allBooks.add(new Book("Neverwhere", "Neil Gaiman", 1996));
        allBooks.add(new Book("Earthsea Cycle", "Ursula K. Le Guin", 1968));
        allBooks.add(new Book("The Name of the Wind", "Patrick Rothfuss", 2007));
        allBooks.add(new Book("Harry Potter", "J.K. Rowling", 1997));
    }

    public static void displayBooksList() {
        createBookList();
        String allBooksString = "";
        for (Book book : allBooks) {
            allBooksString += "\n" + book.getTitle() + " - " + book.getAuthor() + " - " + book.getPublicationYear();
        }
        System.out.print(allBooksString);
    }
}
