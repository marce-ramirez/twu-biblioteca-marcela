package com.twu.biblioteca;

public class Movie {
    private final String title;
    private final int year;
    private final String director;
    private final double rating;
    private final String movieId;
    private final boolean isAvailable = true;

    public Movie(String title, String director, int year, double rating, String movieId) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.movieId = movieId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public boolean isMovieAvailable() {
        return isAvailable;
    }
}
