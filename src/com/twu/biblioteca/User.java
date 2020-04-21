package com.twu.biblioteca;

public class User {

    public String getLibraryNumber() {
        return "551-0684";
    }

    public boolean validatePassword(String enteredPassword) {
        String password = "palitopollito";
        return enteredPassword.equals(password);
    }
}
