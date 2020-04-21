package com.twu.biblioteca;

public class Book {
    private final String title;
    private final String author;
    private final int publicationYear;
    private final String bookId;
    private boolean isAvailable = true;
    private String currentHolder;

    public Book(String title, String author, int publicationYear, String bookId) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.bookId = bookId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getBookId() {
        return bookId;
    }

    public boolean isBookAvailable() {
        return isAvailable;
    }

    public void setBookNotAvailable() {
        isAvailable = false;
    }

    public void setBookAvailable() {
        isAvailable = true;
    }

    public void setCurrentHolder(String userNumber) {
        this.currentHolder = userNumber;
    }

    public String getCurrentHolder() {
        return currentHolder;
    }


}
