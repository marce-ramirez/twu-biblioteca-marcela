package com.twu.biblioteca;

public class User {
    private final String libraryNumber = "551-0684";
    private final String password = "palitopollito";

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public boolean validatePassword(String enteredPassword) {
        return enteredPassword.equals(this.password);
    }
}
