package com.github.androidproject.users;

public class Coach extends User {
    public Coach(String name) {
        super(name);
    }

    public Group createGroup(String name) {
        Group group = new Group(name);
        group.addUser(this);
        return group;
    }

    public User addUser(Athlete athlete) {
        return athlete;
    }

}
