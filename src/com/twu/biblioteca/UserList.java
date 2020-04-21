package com.twu.biblioteca;

import java.util.ArrayList;

public class UserList {
    private final ArrayList<User> userList = new ArrayList<>();

    public void addUser() {
        userList.clear();
        userList.add(new User("551-0684", "Randolph Carter", "rcarter@miskatonic.edu", 6204456));
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public User findUser(String libraryNumber) {
        for (User user : userList) {
            if (user.getLibraryNumber().equals(libraryNumber)) {
                return user;
            }
        }
        return null;
    }
}
