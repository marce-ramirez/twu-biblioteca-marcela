package com.twu.biblioteca;

public class User {
    private final int libraryNumber = 5510684;
    private final String password = "palitopollito";

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
