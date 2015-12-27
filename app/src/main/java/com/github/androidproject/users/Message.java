package com.github.androidproject.users;

import com.github.androidproject.message.Chat;

public class Message {
    private final User user;
    private final String message;

    public Message(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public void to(Chat chat) {
        chat.sendMessage(this);
    }

    public User sender() {
        return user;
    }

    public String content() {
        return message;
    }
}
