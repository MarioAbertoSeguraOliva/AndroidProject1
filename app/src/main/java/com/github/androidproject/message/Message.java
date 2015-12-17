package com.github.androidproject.message;

import com.github.androidproject.users.Group;

public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public void to(Group group) {
        group.sendMessage(this.message);
    }
}
