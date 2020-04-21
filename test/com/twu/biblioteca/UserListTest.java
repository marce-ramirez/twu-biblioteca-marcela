package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class UserListTest {
    private UserList userList;
    private User userToTest;
    private String testLibraryNumber;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public final String userString = "\n" +
            "Name: Randolph Carter\n" +
            "Email: rcarter@miskatonic.edu\n" +
            "Phone: 6204456\n";

    @Before
    public void setUpList() {
        System.setOut(new PrintStream(outContent));
        userList = new UserList();
        userList.addUser();
        userToTest = userList.getUserList().get(0);
        testLibraryNumber = "551-0684";
    }

    @Test
    public void userAddedToUserList() {
        assertEquals(testLibraryNumber, userToTest.getLibraryNumber());
    }

    @Test
    public void findUserByLibraryNumber() {
        User foundUser = userList.findUser(testLibraryNumber);
        assertEquals(userToTest.getLibraryNumber(), foundUser.getLibraryNumber());
    }

    @Test
    public void printUserCorrectInformation() {
        userList.displayUserInformation(testLibraryNumber);
        assertEquals(userString, outContent.toString());
    }
}
