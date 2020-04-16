package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Book testBook;

    @Before
    public void setUpBook () {
        testBook = new Book("The Golden Compass", "Philip Pullman");
    }

    @Test
    public void testBookInformation () {
        assertEquals("The Golden Compass", testBook.getTitle());
        assertEquals("Philip Pullman", testBook.getAuthor());
    }
}