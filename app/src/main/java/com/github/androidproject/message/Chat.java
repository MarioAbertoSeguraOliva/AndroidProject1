package com.github.androidproject.message;

import com.github.androidproject.users.Message;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private List<Message> messages;

    public Chat() {
        messages = new ArrayList<>();
    }

    public List<Message> messages() {
        return this.messages;
    }

    public void sendMessage(Message message) {
        messages.add(message);
    }
}
