package com.github.androidproject.users;

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
        //juan.addUser(pepe).to(evecan);
    }

    @Test
    public void should_invite_users_to_groups() throws Exception {
        Coach juan = new Coach("Juan");
        Group evecan = juan.createGroup("EveCan");
        Athlete pepe = new Athlete("Pepe");
        juan.addUser(pepe).to(evecan);
        assertThat(evecan.users().size(), is(2));
    }


}
