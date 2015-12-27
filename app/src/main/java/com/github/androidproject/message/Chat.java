package com.github.androidproject.message;

import com.github.androidproject.users.Message;
import com.github.androidproject.users.User;

import java.util.HashMap;
import java.util.Map;

public class Chat {
    private Map<User, String> messages;

    public Chat() {
        messages = new HashMap<>();
    }

    public Map<User, String> messages() {
        return this.messages;
    }

    public void sendMessage(Message message) {
        messages.put(message.sender(), message.content());
    }
}
