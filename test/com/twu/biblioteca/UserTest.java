package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private final User testUser = new User();

    @Test
    public void testUserCreation () {
        assertEquals(5510684, testUser.getLibraryNumber());
    }

    @Test
    public void testUserPassword() {
        assertTrue(testUser.validatePassword("palitopollito"));
    }
}