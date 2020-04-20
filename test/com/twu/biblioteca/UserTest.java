package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private User testUser;

    @Before
    public void setUpUser () {
        testUser = new User(5510684, "palitopollito");
    }

    @Test
    public void testUserCreation () {
        assertEquals(5510684, testUser.getLibraryNumber());
    }

    @Test
    public void testUserPassword() {
        assertTrue(testUser.validatePassword("palitopollito"));
    }
}