package com.github.androidproject.users;

import java.util.ArrayList;
import java.util.List;

public abstract class User{
    protected String name;
    protected List<Group> groups;

    public List<Group> groups() {
        return groups;
    }

    public void groups(List<Group> groups) {
        this.groups = groups;
    }

    public User(String name) {
        this.name = name;
        groups = new ArrayList<>();

    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }


    public void to(Group group) {
        group.addUser(this);
        groups.add(group);
    }

    public Message sendMessage(String message){
        return new Message(this, message);
    }

    public void from(Group group) {
        leaves(group);
    }

    public void leaves(Group group) {
        group.users().remove(this);
        this.groups().remove(group);
    }
}
