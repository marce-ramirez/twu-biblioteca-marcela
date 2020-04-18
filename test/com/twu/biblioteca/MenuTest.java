package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class MenuTest {
    private Menu testMenu;
    ByteArrayInputStream oneIn = new ByteArrayInputStream("1".getBytes());
    ByteArrayInputStream twoIn = new ByteArrayInputStream("2".getBytes());
    String testInput;

    @Before
    public void createMenu() {
        testMenu = new Menu();
        testMenu.generateAppMenu();
    }

    @Test
    public void showCorrectMenuItems() {
        assertEquals("1 - List of books", testMenu.menu.get(0));
        assertEquals("2 - Checkout a book", testMenu.menu.get(1));
    }

    @Test
    public void collectCorrectInputFromTheUser() {
        System.setIn(oneIn);
        testInput = testMenu.getUserInput();
        assertEquals("1", testInput);
        System.setIn(twoIn);
        testInput = testMenu.getUserInput();
        assertEquals("2", testInput);
    }

}