package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    private final ArrayList<Book> allBooks = new ArrayList<>();

    public void createBookList() {
        allBooks.clear();
        allBooks.add(new Book("His Dark Materials", "Philip Pullman", 1995, "0892"));
        allBooks.add(new Book("Good Omens", "Neil Gaiman and Terry Pratchett", 1990, "0791"));
        allBooks.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "1603"));
        allBooks.add(new Book("Neverwhere", "Neil Gaiman", 1996, "0935"));
        allBooks.add(new Book("Earthsea Cycle", "Ursula K. Le Guin", 1968, "2448"));
        allBooks.add(new Book("The Name of the Wind", "Patrick Rothfuss", 2007, "3001"));
        allBooks.add(new Book("Harry Potter", "J.K. Rowling", 1997, "0204"));
    }

    public void displayBookList() {
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

    public Book findBookById(String id) {
        for (Book book : allBooks) {
            if (book.getBookId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void checkoutBook(String bookId) {
        Book foundBook = findBookById(bookId);
        if (foundBook != null && foundBook.isBookAvailable()) {
            foundBook.setBookNotAvailable();
            BibliotecaApp.setOutputMessage("\nThank you! Enjoy the book\n");
        } else {
            BibliotecaApp.setOutputMessage("\nSorry, that book is not available\n");
        }
        System.out.print(BibliotecaApp.getOutputMessage());
    }

    public void returnBook(String bookId) {
        Book foundBook = findBookById(bookId);
        if (foundBook != null && !foundBook.isBookAvailable()) {
            foundBook.setBookAvailable();
            BibliotecaApp.setOutputMessage("\nThank you for returning the book\n");
        } else {
            BibliotecaApp.setOutputMessage("\nThat is not a valid book to return\n");
        }
        System.out.print(BibliotecaApp.getOutputMessage());
    }
}
