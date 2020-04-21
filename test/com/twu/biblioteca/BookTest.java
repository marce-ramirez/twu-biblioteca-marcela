package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Book testBook;
    private Book borrowedBook;

    @Before
    public void setUpBook () {
        testBook = new Book("The Golden Compass", "Philip Pullman", 1995, "0285");
        borrowedBook = new Book("Earthsea Cycle", "Ursula K. Le Guin", 1968, "2448");
    }

    @Test
    public void testBookInformationAfterCreation () {
        assertEquals("The Golden Compass", testBook.getTitle());
        assertEquals("Philip Pullman", testBook.getAuthor());
        assertEquals(1995, testBook.getPublicationYear());
        assertEquals("0285", testBook.getBookId());
        assertTrue(testBook.isBookAvailable());
    }

    @Test
    public void seeUserThatBorrowedBook () {
        borrowedBook.setCurrentHolder("720-4899");
        assertEquals("720-4899", borrowedBook.getCurrentHolder());
    }
}