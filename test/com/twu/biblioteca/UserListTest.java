package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class UserListTest {
    private UserList userList;
    private User userToTest;

    @Before
    public void setUpList() {
        userList = new UserList();
        userList.addUser();
    }

    @Test
    public void userAddedToUserList() {
        userToTest = userList.getUserList().get(0);
        assertEquals(5510684, userToTest.getLibraryNumber());
    }

}