package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {
    ArrayList<String> menu = new ArrayList<>();

    public void generateAppMenu() {
        addMenuItems();
    }

    public void addMenuItems() {
        menu.add("1 - List of books");
        menu.add("2 - Checkout a book");
        menu.add("3 - Return a bok");
        menu.add("4 - Quit");
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
        return  BibliotecaApp.collectInputFromUser().toLowerCase();
    }
}

