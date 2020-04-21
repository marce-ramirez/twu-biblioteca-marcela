package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private User testUser;

    @Before
    public void setUpUser() {
        testUser = new User("551-0684", "Randolph Carter", "rcarter@miskatonic.edu", 6204456);
    }

    @Test
    public void testUserInformationAfterCreation() {
        assertEquals("551-0684", testUser.getLibraryNumber());
        assertEquals("Randolph Carter", testUser.getName());
        assertEquals("rcarter@miskatonic.edu", testUser.getEmail());
        assertEquals(6204456, testUser.getPhoneNumber());
    }

}