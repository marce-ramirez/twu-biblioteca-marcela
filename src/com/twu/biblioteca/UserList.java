package com.twu.biblioteca;

import java.util.ArrayList;

public class UserList {
    private final ArrayList<User> userList = new ArrayList<>();

    public void addUser() {
        userList.clear();
        userList.add(new User());
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
}
