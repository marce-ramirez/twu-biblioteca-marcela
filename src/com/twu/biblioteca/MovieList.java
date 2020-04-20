package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieList {
    private final ArrayList<Movie> allMovies = new ArrayList<>();

    public void createMovieList() {
        allMovies.clear();
        allMovies.add(new Movie("Big Fish", "Tim Burton", 2004, 8.0, "3472"));
        allMovies.add(new Movie("Princess Mononoke", "Hayao Miyazaki", 1997, 8.4, "2183"));
        allMovies.add(new Movie("Thor: The Dark World", "Alan Taylor", 2013, 6.9, "4588"));
    }

    public void displayMovieList() {
        StringBuilder movieList = new StringBuilder();
        for (Movie movie : allMovies) {
            if (movie.isMovieAvailable()) {
                movieList
                    .append("\n")
                    .append(movie.getTitle())
                    .append(" | ")
                    .append(movie.getDirector())
                    .append(" | ")
                    .append(movie.getYear())
                    .append(" | Rating: ")
                    .append(movie.getRating())
                    .append(" | ID: ")
                    .append(movie.getMovieId());
            }

        }
        movieList.append("\n");
        System.out.print(movieList);
    }

    public Movie findMovieById(String id) {
        for (Movie movie : allMovies) {
            if (movie.getMovieId().equals(id)) {
                return movie;
            }
        }
        return null;
    }

    public void checkoutMovie(String movieId) {
        Movie foundMovie = findMovieById(movieId);
        if (foundMovie != null && foundMovie.isMovieAvailable()) {
            foundMovie.setMovieNotAvailable();
            BibliotecaApp.setOutputMessage("\nThank you! Enjoy the movie\n");
        } else {
            BibliotecaApp.setOutputMessage("\nSorry, that movie is not available\n");
        }
        System.out.print(BibliotecaApp.getOutputMessage());
    }

    public void returnMovie(String movieId) {
        Movie foundMovie = findMovieById(movieId);
        if (foundMovie != null && !foundMovie.isMovieAvailable()) {
            foundMovie.setMovieAvailable();
            BibliotecaApp.setOutputMessage("\nThank you for returning the movie\n");
        } else {
            BibliotecaApp.setOutputMessage("\nThat is not a valid movie to return\n");
        }
        System.out.print(BibliotecaApp.getOutputMessage());
    }
}
