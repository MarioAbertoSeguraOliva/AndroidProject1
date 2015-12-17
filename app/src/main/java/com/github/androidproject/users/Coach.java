package com.github.androidproject.users;

import com.github.androidproject.message.Message;

public class Coach extends User implements UserEdition {
    public Coach(String name) {
        super(name);
    }

    @Override
    Message sendMessage(Message message) {
        return message;
    }

    public Group createGroup(String name) {
        Group group = new Group(name);
        group.addUser(this);
        return group;
    }

    public User addUser(User user) {
        return user;
    }
}
