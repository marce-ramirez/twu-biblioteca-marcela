package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Book testBook;

    @Before
    public void setUpBook () {
        testBook = new Book("The Golden Compass", "Philip Pullman", 1995, "0285");
    }

    @Test
    public void testBookInformationAfterCreation () {
        assertEquals("The Golden Compass", testBook.getTitle());
        assertEquals("Philip Pullman", testBook.getAuthor());
        assertEquals(1995, testBook.getPublicationYear());
        assertEquals("0285", testBook.getBookId());
        assertTrue(testBook.isBookAvailable());
    }


}