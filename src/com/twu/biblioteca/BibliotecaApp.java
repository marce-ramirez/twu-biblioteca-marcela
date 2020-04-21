package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {
    private static final Menu menu = new Menu();
    private static final BookList bookList = new BookList();
    private static final MovieList movieList = new MovieList();
    private static final UserList userList = new UserList();
    private static String currentUser;
    private static boolean appIsRunning = true;
    private static String outputMessage = "";

    public static void main(String[] args) {
        displayWelcomeMessage();
        initialAppSetup();
        while (isAppRunning()) {
            String userInput = menu.getUserInput();
            if (userInput == null) {
                processUserInput("");
            } else {
                processUserInput(userInput);
            }
        }
    }

    public static void initialAppSetup() {
        bookList.createBookList();
        movieList.createMovieList();
        userList.addUser();
        menu.generateLoggedOutMenu();
    }

    public static String getOutputMessage() {
        return outputMessage;
    }

    public static void setOutputMessage(String message) {
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

    public static void displayWelcomeMessage() {
        setOutputMessage("\nWelcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
        System.out.print(outputMessage);
    }

    public static User validateUser() {
        System.out.print("Enter library number: ");
        String libraryNumber = collectInputFromUser();
        return userList.findUser(libraryNumber);
    }

    public static boolean validatePassword(User user) {
        System.out.print("Enter password: ");
        String enteredPassword = collectInputFromUser();
        return user.validatePassword(enteredPassword);
    }

    public static void userLogin(User validUser, boolean isValidPassword) {
        if (validUser != null) {
            if (isValidPassword) {
                currentUser = validUser.getLibraryNumber();
                System.out.println("\nHello " + currentUser);
                menu.generateLoggedInMenu();
            } else {
                System.out.println("\nWrong password");
            }
        } else {
            System.out.print("\nThis user doesn't exist. Please try again\n");
        }
    }

    public static void processUserInput(String userInput) {
        String enteredId;
        if (currentUser == null) {
            switch (userInput) {
                case "1":
                    User validUser = validateUser();
                    boolean isValidPassword = validatePassword(validUser);
                    userLogin(validUser, isValidPassword);
                    break;
                case "2":
                    System.out.print("\nGood bye!\n");
                    setAppNotRunning();
                    break;
                default:
                    System.out.print("\nPlease select a valid option\n");
                    break;
            }
        } else {
            switch (userInput) {
                case "1":
                    bookList.displayBookList();
                    break;
                case "2":
                    System.out.print("Please enter the book ID: ");
                    enteredId = collectInputFromUser();
                    bookList.checkoutBook(enteredId);
                    break;
                case "3":
                    System.out.print("Please enter the book ID: ");
                    enteredId = collectInputFromUser();
                    bookList.returnBook(enteredId);
                    break;
                case "4":
                    movieList.displayMovieList();
                    break;
                case "5":
                    System.out.print("Please enter the movie ID: ");
                    enteredId = collectInputFromUser();
                    movieList.checkoutMovie(enteredId);
                    break;
                case "6":
                    System.out.print("Please enter the movie ID: ");
                    enteredId = collectInputFromUser();
                    movieList.returnMovie(enteredId);
                    break;
                case "7":
                    System.out.print("\nGood bye!\n");
                    setAppNotRunning();
                    break;
                default:
                    System.out.print("\nPlease select a valid option\n");
                    break;
            }
        }
    }

}
