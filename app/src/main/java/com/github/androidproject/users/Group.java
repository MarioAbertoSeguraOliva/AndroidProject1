package com.github.androidproject.users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {
    private String name;
    private Set<User> users;
    private List<String> messages;

    public Group(String name) {
        this.name = name;
        users = new HashSet<>();
        messages = new ArrayList<>();
    }

    public void addUser(User athlete) {
        users.add(athlete);
    }

    public Set<User> users() {
        return users;
    }

    public void sendMessage(String message) {
        messages.add(message);
    }


    public List<String> messages() {
        return messages;
    }
}
