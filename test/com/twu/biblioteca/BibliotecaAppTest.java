package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    public static final String booksList = "\nHis Dark Materials | Philip Pullman | 1995 | ID: 0892" +
            "\nGood Omens | Neil Gaiman and Terry Pratchett | 1990 | ID: 0791" +
            "\nThe Hobbit | J.R.R. Tolkien | 1937 | ID: 1603" +
            "\nNeverwhere | Neil Gaiman | 1996 | ID: 0935" +
            "\nEarthsea Cycle | Ursula K. Le Guin | 1968 | ID: 2448" +
            "\nThe Name of the Wind | Patrick Rothfuss | 2007 | ID: 3001" +
            "\nHarry Potter | J.K. Rowling | 1997 | ID: 0204\n";
    private static final String invalidOptionMessage = "\nPlease select a valid option\n";
    private static final String testBookId = "0892";
    private static final String invalidBookId = "0000";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
        BibliotecaApp.createBookList();
    }

    @Test
    public void displayInitialWelcomeMessage() {
        BibliotecaApp.displayWelcomeMessage();
        String welcomeMessage = "\nWelcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        assertEquals(welcomeMessage, outContent.toString());
    }

    @Test
    public void displayBookListWhenUserEntersListOption() {
        BibliotecaApp.processUserInput("1");
        assertEquals(booksList, outContent.toString());
    }

    @Test
    public void successfulBookCheckoutOnValidId() {
        Book bookToTest = BibliotecaApp.findBookById(testBookId);
        assert bookToTest != null;
        assertTrue(bookToTest.isBookAvailable());
        System.setIn(new ByteArrayInputStream(testBookId.getBytes()));
        BibliotecaApp.processUserInput("2");
        assertFalse(bookToTest.isBookAvailable());
        assertEquals("\nThank you! Enjoy the book\n", BibliotecaApp.getOutputMessage());
    }

    @Test
    public void bookCheckoutFailure() {
        System.setIn(new ByteArrayInputStream(invalidBookId.getBytes()));
        BibliotecaApp.processUserInput("2");
        assertEquals("\nSorry, that book is not available\n", BibliotecaApp.getOutputMessage());
    }

    @Test
    public void successfulBookReturnOnValidId() {
        Book bookToTest = BibliotecaApp.findBookById(testBookId);
        System.setIn(new ByteArrayInputStream(testBookId.getBytes()));
        BibliotecaApp.processUserInput("2");
        System.setIn(new ByteArrayInputStream(testBookId.getBytes()));
        BibliotecaApp.processUserInput("3");
        assert bookToTest != null;
        assertTrue(bookToTest.isBookAvailable());
    }

    @Test
    public void closeAppWhenUserEntersQuit() {
        BibliotecaApp.processUserInput("4");
        assertFalse(BibliotecaApp.isAppRunning());
    }

    @Test
    public void showMessageWhenInputIsInvalid() {
        String invalidOption = "Test";
        BibliotecaApp.processUserInput(invalidOption);
        assertEquals(invalidOptionMessage, outContent.toString());
    }
}
