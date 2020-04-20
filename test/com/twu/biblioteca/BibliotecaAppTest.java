package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private static final String invalidOptionMessage = "\nPlease select a valid option\n";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void displayInitialWelcomeMessage() {
        BibliotecaApp.displayWelcomeMessage();
        String welcomeMessage = "\nWelcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        assertEquals(welcomeMessage, outContent.toString());
    }

    @Test
    public void closeAppWhenUserEntersQuit() {
        BibliotecaApp.processUserInput("6");
        assertFalse(BibliotecaApp.isAppRunning());
    }

    @Test
    public void showMessageWhenInputIsInvalid() {
        String invalidOption = "Test";
        BibliotecaApp.processUserInput(invalidOption);
        assertEquals(invalidOptionMessage, outContent.toString());
    }
}
