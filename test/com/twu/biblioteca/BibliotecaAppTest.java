package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    public static final String booksList = "\nHis Dark Materials - Philip Pullman - 1995" +
            "\nGood Omens - Neil Gaiman and Terry Pratchett - 1990" +
            "\nThe Hobbit - J.R.R. Tolkien - 1937" +
            "\nNeverwhere - Neil Gaiman - 1996" +
            "\nEarthsea Cycle - Ursula K. Le Guin - 1968" +
            "\nThe Name of the Wind - Patrick Rothfuss - 2007" +
            "\nHarry Potter - J.K. Rowling - 1997\n\n";
    private static final String invalidOptionMessage = "\nPlease select a valid option\n\n";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void displayInitialWelcomeMessage() {
        BibliotecaApp.displayWelcomeMessage();
        String welcomeMessage = "\nWelcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n\n";
        assertEquals(welcomeMessage, outContent.toString());
    }

    @Test
    public void displayBookListWhenUserEntersOne() {
        BibliotecaApp.createBookList();
        BibliotecaApp.processUserInput("1");
        assertEquals(booksList, outContent.toString());
    }

    @Test
    public void showMessageWhenInputIsInvalid() {
        String invalidOption = "Test";
        BibliotecaApp.processUserInput(invalidOption);
        assertEquals(invalidOptionMessage, outContent.toString());
    }
}
