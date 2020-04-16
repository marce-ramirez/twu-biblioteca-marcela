package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    private static ArrayList<Book> allBooks = new ArrayList<Book>();

    public static void main(String[] args) {
        displayWelcomeMessage();
        displayBooksList();
    }

    public static void displayWelcomeMessage () {
        System.out.print("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
    }

    public static void createBookList() {
        allBooks.add(new Book("His Dark Materials", "Philip Pullman"));
        allBooks.add(new Book("Good Omens", "Neil Gaiman and Terry Pratchett"));
        allBooks.add(new Book("The Hobbit", "J.R.R. Tolkien"));
        allBooks.add(new Book("Neverwhere", "Neil Gaiman"));
        allBooks.add(new Book("Earthsea Cycle", "Ursula K. Le Guin"));
        allBooks.add(new Book("The Name of the Wind", "Patrick Rothfuss"));
        allBooks.add(new Book("Harry Potter", "J.K. Rowling"));
    }

    public static void displayBooksList() {
        createBookList();
        String allBooksString = "";
        for (Book book : allBooks) {
            allBooksString += "\n" + book.getTitle() + " - " + book.getAuthor();
        }
        System.out.print(allBooksString);
    }
}
