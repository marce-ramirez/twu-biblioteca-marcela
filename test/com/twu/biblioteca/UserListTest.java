package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserListTest {
    private UserList userList;
    private User userToTest;

    @Before
    public void setUpList() {
        userList = new UserList();
        userList.addUser();
        userToTest = userList.getUserList().get(0);
    }

    @Test
    public void userAddedToUserList() {
        assertEquals("551-0684", userToTest.getLibraryNumber());
    }

    @Test
    public void findUserByLibraryNumber(){
        User foundUser = userList.findUser("551-0684");
        assertEquals(userToTest.getLibraryNumber(), foundUser.getLibraryNumber());
    }
}
