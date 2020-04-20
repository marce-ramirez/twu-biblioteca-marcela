package com.twu.biblioteca;

public class User {
    private final int libraryNumber;
    private final String password;

    public User(int libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public int getLibraryNumber() {
        return libraryNumber;
    }


    public boolean validatePassword(String enteredPassword) {
        if (enteredPassword.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }
}
