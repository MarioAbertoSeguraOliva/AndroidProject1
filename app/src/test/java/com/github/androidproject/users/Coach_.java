package com.github.androidproject.users;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Coach_ {
    @Test
    public void should_create_groups_() throws Exception {
        Coach juan = new Coach("Juan");
        Group evecan = juan.createGroup("EveCan");
        assertThat(evecan.users().size(), is(1));
        //Athlete pepe = new Athlete("Pepe");
        //juan.addUser(pepe).to(evecan);
    }
}
