package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String name;
    private String email;
    private int phoneNumber;

    public User(String libraryNumber, String name, String email, int phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public boolean validatePassword(String enteredPassword) {
        String password = "palitopollito";
        return enteredPassword.equals(password);
    }
}
