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
        movieList.append("\n");
        System.out.print(movieList);
    }
}
