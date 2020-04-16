package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Book testBook;

    @Before
    public void setUpBook () {
        testBook = new Book("The Golden Compass", "Phillip Pullman");
    }

    @Test
    public void testBookTitle () {
        assertEquals("The Golden Compass", testBook.getTitle());
    }

    @Test
    public void testBookAuthor () {
        assertEquals("Phillip Pullman", testBook.getAuthor());
    }
}