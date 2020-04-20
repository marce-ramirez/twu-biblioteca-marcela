package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {
    private static final Menu menu = new Menu();
    private static final BookList bookList = new BookList();
    private static boolean appIsRunning = true;
    private static String outputMessage = "";

    public static void main(String[] args) {
        displayWelcomeMessage();
        bookList.createBookList();
        menu.generateAppMenu();
        while(isAppRunning()) {
            String userInput = menu.getUserInput();
            if (userInput == null) {
                processUserInput("");
            } else {
                processUserInput(userInput);
            }
        }
    }

    public static String getOutputMessage() {
        return outputMessage;
    }

    public static void setOutputMessage (String message) {
        outputMessage = message;
    }

    public static boolean isAppRunning() {
        return appIsRunning;
    }

    public static void setAppNotRunning() {
        appIsRunning = false;
    }

    public static String collectInputFromUser() {
        String userInput = "";
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            userInput = is.readLine();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return userInput;
    }

    public static void displayWelcomeMessage () {
        setOutputMessage("\nWelcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
        System.out.print(outputMessage);
    }

    public static void processUserInput(String userInput) {
        String bookId;
                switch (userInput) {
            case "1":
                bookList.displayBookList();
                break;
            case "2":
                System.out.print("Please enter the book ID: ");
                bookId = collectInputFromUser();
                bookList.checkoutBook(bookId);
                break;
            case "3":
                System.out.print("Please enter the book ID: ");
                bookId = collectInputFromUser();
                bookList.returnBook(bookId);
                break;
            case "4":
                System.out.print("\nGood bye!\n");
                setAppNotRunning();
                break;
            default:
                System.out.print("\nPlease select a valid option\n");
                break;
       }
    }

}
