package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private static final String invalidOptionMessage = "\nPlease select a valid option\n";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    User testUser = new User();

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
        BibliotecaApp.processUserInput("2");
        assertFalse(BibliotecaApp.isAppRunning());
    }

    @Test
    public void showMessageWhenInputIsInvalid() {
        String invalidOption = "Test";
        BibliotecaApp.processUserInput(invalidOption);
        assertEquals(invalidOptionMessage, outContent.toString());
    }

    @Test
    public void validateUserLibraryNumber() {
        BibliotecaApp.initialAppSetup();
        ByteArrayInputStream userNumber = new ByteArrayInputStream("551-0684".getBytes());
        System.setIn(userNumber);
        User testUser = BibliotecaApp.validateUser();
        assertEquals("551-0684", testUser.getLibraryNumber());
    }

    @Test
    public void returnNullWhenUserNotFound() {
        ByteArrayInputStream wrongUserNumber = new ByteArrayInputStream("555-0000".getBytes());
        System.setIn(wrongUserNumber);
        User testUser = BibliotecaApp.validateUser();
        assertNull(testUser);
    }

    @Test
    public void showWhenPasswordIsValid() {
        ByteArrayInputStream userPassword = new ByteArrayInputStream("palitopollito".getBytes());
        System.setIn(userPassword);
        boolean isPasswordValid = BibliotecaApp.validatePassword(testUser);
        assertTrue(isPasswordValid);
    }

    @Test
    public void showWhenPasswordIsNotValid() {
        ByteArrayInputStream wrongPassword = new ByteArrayInputStream("wrongpass".getBytes());
        System.setIn(wrongPassword);
        boolean isPasswordValid = BibliotecaApp.validatePassword(testUser);
        assertFalse(isPasswordValid);
    }

    @Test
    public void testUserLogin() {
        BibliotecaApp.userLogin(testUser, true);
        assertEquals("\nHello 551-0684\n", outContent.toString());
    }

    @Test
    public void seeNotificationWhenUserNotFound() {
        BibliotecaApp.userLogin(null, true);
        assertEquals("\nThis user doesn't exist. Please try again\n", outContent.toString());
    }

    @Test
    public void seeNotificationWhenPasswordInvalid() {
        BibliotecaApp.userLogin(testUser, false);
        assertEquals("\nWrong password\n", outContent.toString());
    }
}
