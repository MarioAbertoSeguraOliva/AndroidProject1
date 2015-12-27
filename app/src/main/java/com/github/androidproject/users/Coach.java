package com.github.androidproject.users;

import com.github.androidproject.message.Chat;

public class Coach extends User implements UserEdition {
    public Coach(String name) {
        super(name);
    }

    public Group createGroup(String name) {
        Group group = new Group(name);
        group.addUser(this);
        return group;
    }

    public User addUser(User user) {
        return user;
    }

    public Group changeGroupName(Group group) {
        return group;
    }
}
