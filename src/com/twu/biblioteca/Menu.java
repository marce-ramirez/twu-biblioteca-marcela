package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {
    ArrayList<String> menu = new ArrayList<>();

    public void generateLoggedOutMenu() {
        menu.clear();
        menu.add("1 - Login");
        menu.add("2 - Quit");
    }

    public void generateLoggedInMenu() {
        menu.clear();
        menu.add("1 - List of books");
        menu.add("2 - Checkout a book");
        menu.add("3 - Return a book");
        menu.add("4 - List of movies");
        menu.add("5 - Checkout a movie");
        menu.add("6 - Return a movie");
        menu.add("7 - My profile");
        menu.add("8 - Quit");
    }

    public void printAppMenu() {
        System.out.print("\n");
        for (String menuItem : menu) {
            System.out.println(menuItem);
        }
    }

    public String getUserInput() {
        printAppMenu();
        System.out.print("\nEnter an option: ");
        return BibliotecaApp.collectInputFromUser().toLowerCase();
    }
}

