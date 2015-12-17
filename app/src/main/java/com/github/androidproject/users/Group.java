package com.github.androidproject.users;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<User> users;
    private List<String> messages;

    public Group(String name) {
        this.name = name;
        users = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public void addUser(User athlete) {
        if(!users.contains(athlete)) users.add(athlete);
    }

    public List<User> users() {
        return users;
    }

    public void sendMessage(String message) {
        messages.add(message);
    }


    public List<String> messages() {
        return messages;
    }
}
