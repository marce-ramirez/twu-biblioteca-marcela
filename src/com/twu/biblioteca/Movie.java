package com.twu.biblioteca;

public class Movie {
    private String title;
    private int year;
    private String director;
    private double rating;
    private String movieId;
    private boolean isAvailable = true;

    public Movie(String title, int year, String director, double rating, String movieId) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.movieId = movieId;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
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
