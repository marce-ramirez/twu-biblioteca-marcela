package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MovieListTest {
    private MovieList movieList;
    public final String movieListString = "\nBig Fish | Tim Burton | 2004 | Rating: 8.0 | ID: 3472" +
            "\nPrincess Mononoke | Hayao Miyazaki | 1997 | Rating: 8.4 | ID: 2183" +
            "\nThor: The Dark World | Alan Taylor | 2013 | Rating: 6.9 | ID: 4588\n";

    private final String testMovieId = "3472";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStream() {
        movieList = new MovieList();
        System.setOut(new PrintStream(outContent));
        movieList.createMovieList();
    }

    @Test
    public void displayMovieListWhenUserEntersListOption() {
        movieList.displayMovieList();
        assertEquals(movieListString, outContent.toString());
    }
}