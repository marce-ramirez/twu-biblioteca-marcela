package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BibliotecaAppTest {

    private final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
    public static final String booksList = "\nHis Dark Materials - Philip Pullman" +
            "\nGood Omens - Neil Gaiman and Terry Pratchett" +
            "\nThe Hobbit - J.R.R. Tolkien" +
            "\nNeverwhere - Neil Gaiman" +
            "\nEarthsea Cycle - Ursula K. Le Guin" +
            "\nThe Name of the Wind - Patrick Rothfuss" +
            "\nHarry Potter - J.K. Rowling";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

//    private final PrintStream originalOut = System.out;
    private BibliotecaApp biblioteca;

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
        biblioteca = new BibliotecaApp();
    }

    @Test
    public void displayInitialWelcomeMessage() {
        biblioteca.displayWelcomeMessage();
        assertEquals(welcomeMessage, outContent.toString());
    }

    @Test
    public void printListOfBooksWhenAppStarts() {
        biblioteca.displayBooksList();
        assertEquals(booksList, outContent.toString());
    }
}
