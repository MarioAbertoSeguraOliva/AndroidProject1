package com.github.androidproject.users;

public class Coach extends User implements UserEdition {
    public Coach(String name) {
        super(name);
    }

    public Group createGroup(String name) {
        Group group = new Group(name);
        group.addUser(this);
        super.groups().add(group);
        return group;
    }

    public User addUser(User user) {
        return user;
    }

    public Group changeGroupName(Group group) {
        return group;
    }

    public void deleteGroup(Group group) {
        //TODO ask if he/she really wants to erase it
        if (super.groups().contains(group)) super.groups().remove(group);
        else System.out.println("No perteneces a este grupo");
    }

    public User removeUser(User user) {
        return user;
    }
}
