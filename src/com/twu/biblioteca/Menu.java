package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {
    ArrayList<String> menu = new ArrayList<String>();

    public void generateAppMenu() {
        addMenuItems();
        printAppMenu();
    }

    public void addMenuItems() {
        menu.add("1 - List of Books");
        menu.add("2 - Quit");
    }

    public void printAppMenu() {
        for (String menuItem : menu) {
            System.out.println(menuItem);
        }
        System.out.print("\n");
    }

    public String getUserInput() {
        String userInput = null;
        System.out.print("Enter an option: ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            userInput = is.readLine();
            if (userInput.length() == 0 )  return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return userInput.toLowerCase();
    }
}

