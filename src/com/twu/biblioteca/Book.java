package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private String bookId;
    private boolean isAvailable = true;

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

    public String getBookId() { return bookId; }

    public boolean isBookAvailable() {
        return isAvailable;
    }

    public void setBookAvailable() {
        isAvailable = true;
    }

    public void setBookNotAvailable() {
        isAvailable = false;
    }
}
