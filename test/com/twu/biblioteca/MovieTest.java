package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    private Movie testMovie;

    @Before
    public void setUpBook () {
        testMovie = new Movie("Big Fish", "Tim Burton", 2004, 8.0, "3472");
    }

    @Test
    public void testBookInformationAfterCreation () {
        assertEquals("Big Fish", testMovie.getTitle());
        assertEquals(2004, testMovie.getYear());
        assertEquals("Tim Burton", testMovie.getDirector());
        assertEquals(8.0, testMovie.getRating(), 0);
        assertEquals("3472", testMovie.getMovieId());
        assertTrue(testMovie.isMovieAvailable());
    }
}
