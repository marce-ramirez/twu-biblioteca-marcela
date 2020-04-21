package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BookListTest {
    private BookList bookList;
    private final String bookListString = "\nHis Dark Materials | Philip Pullman | 1995 | ID: 0892" +
            "\nGood Omens | Neil Gaiman and Terry Pratchett | 1990 | ID: 0791" +
            "\nThe Hobbit | J.R.R. Tolkien | 1937 | ID: 1603" +
            "\nNeverwhere | Neil Gaiman | 1996 | ID: 0935" +
            "\nEarthsea Cycle | Ursula K. Le Guin | 1968 | ID: 2448" +
            "\nThe Name of the Wind | Patrick Rothfuss | 2007 | ID: 3001" +
            "\nHarry Potter | J.K. Rowling | 1997 | ID: 0204\n";
    private final String testBookId = "0892";
    private final String testUserNumber = "551-0684";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStream() {
        bookList = new BookList();
        System.setOut(new PrintStream(outContent));
        bookList.createBookList();
    }

    @Test
    public void displayBookListWhenUserEntersListOption() {
        bookList.displayBookList();
        assertEquals(bookListString, outContent.toString());
    }

    @Test
    public void successfulBookCheckoutOnValidId() {
        User testUser = new User("551-0684", "Randolph Carter", "rcarter@miskatonic.edu", 6204456);
        BibliotecaApp.userLogin(testUser, true);
        Book bookToTest = bookList.findBookById(testBookId);
        assert bookToTest != null;
        assertTrue(bookToTest.isBookAvailable());
        bookList.checkoutBook(testBookId, testUserNumber);
        assertFalse(bookToTest.isBookAvailable());
        assertEquals(testUserNumber, bookToTest.getCurrentHolder());
        assertEquals("\nThank you! Enjoy the book\n", BibliotecaApp.getOutputMessage());
    }

    @Test
    public void bookCheckoutFailure() {
        String invalidBookId = "0000";
        bookList.checkoutBook(invalidBookId, testUserNumber);
        assertEquals("\nSorry, that book is not available\n", BibliotecaApp.getOutputMessage());
    }

    @Test
    public void notificationBorrowedBook() {
        String invalidBookId = "2448";
        bookList.checkoutBook(invalidBookId, "720-4899");
        bookList.checkoutBook(invalidBookId, testUserNumber);
        assertEquals("\nThe user 720-4899 has this book\n", BibliotecaApp.getOutputMessage());
    }

    @Test
    public void successfulBookReturnOnValidId() {
        Book bookToTest = bookList.findBookById(testBookId);
        bookList.checkoutBook(testBookId, testUserNumber);
        bookList.returnBook(testBookId);
        assert bookToTest != null;
        assertTrue(bookToTest.isBookAvailable());
        assertEquals("\nThank you for returning the book\n", BibliotecaApp.getOutputMessage());
    }

    @Test
    public void bookReturnFailure() {
        bookList.returnBook(testBookId);
        assertEquals("\nThat is not a valid book to return\n", BibliotecaApp.getOutputMessage());
    }
}