package com.github.androidproject.users;

import com.github.androidproject.message.Message;

public class Athlete extends User {
    public Athlete(String name) {
        super(name);
    }

    @Override
    Message sendMessage(Message message) {
        return message;
    }
}
