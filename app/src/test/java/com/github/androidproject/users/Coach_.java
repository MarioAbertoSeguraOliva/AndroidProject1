package com.github.androidproject.users;

import com.github.androidproject.message.Message;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Coach_ {
    @Test
    public void should_create_groups() throws Exception {
        Coach juan = new Coach("Juan");
        Group evecan = juan.createGroup("EveCan");
        assertThat(evecan.users().size(), is(1));
        //Athlete pepe = new Athlete("Pepe");
        //Group prueba = pepe.createGroup("Prueba");
    }

    @Test
    public void should_invite_users_to_groups() throws Exception {
        Coach juan = new Coach("Juan");
        Group evecan = juan.createGroup("EveCan");
        Athlete pepe = new Athlete("Pepe");
        Coach marcos = new Coach("Marcos");
        Athlete pepe2 = new Athlete("Pepe");
        juan.addUser(pepe).to(evecan);
        juan.addUser(marcos).to(evecan);
        assertThat(evecan.users().size(), is(3));
        juan.addUser(pepe).to(evecan);
        assertThat(evecan.users().size(), is(3));
        juan.addUser(pepe2).to(evecan);
        assertThat(evecan.users().size(), is(4));
    }

    @Test
    public void should_send_messages_to_group() throws Exception {
        Coach juan = new Coach("Juan");
        Group evecan = juan.createGroup("EveCan");
        Athlete pepe = new Athlete("Pepe");
        juan.addUser(pepe).to(evecan);
        Message message = new Message("This is the training....");
        juan.sendMessage(message).to(evecan);
        assertThat(evecan.users().size(), is(2));
        assertThat(evecan.messages().size(), is(1));
    }


}
