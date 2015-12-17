package com.github.androidproject.users;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<User> users;

    public Group(String name) {
        this.name = name;
        users = new ArrayList<>();
    }

    public void addUser(User athlete) {
        if(!users.contains(athlete)) users.add(athlete);
    }

    public List<User> users() {
        return users;
    }
}
