package com.github.androidproject.users;

import com.github.androidproject.message.Chat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
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
    public void should_send_messages_to_group() throws Exception {
        Coach juan = new Coach("Juan");
        Group group = juan.createGroup("EveCan");
        Athlete pepe = new Athlete("Pepe");

        juan.addUser(pepe).to(group);
        juan.sendMessage("Hola Pepe").to(group.chat());
        assertThat(group.users().size(), is(2));
        assertThat(group.chat().messages().size(), is(1));
        assertThat(group.chat().messages().get(0).sender(), CoreMatchers.<User>is(juan));

        juan.sendMessage("¿Qué tal todo?").to(group.chat());
        assertThat(group.chat().messages().size(), is(2));
        assertThat(group.chat().messages().get(1).sender(), CoreMatchers.<User>is(juan));
        assertThat(group.chat().messages().get(1).content(), is("¿Qué tal todo?"));
    }

    @Test
    public void should_change_group_name() throws Exception {
        Coach juan = new Coach("Juan");
        Group group = juan.createGroup("EveCan");
        juan.changeGroupName(group).to("EII");
        assertThat(group.name(), is("EII"));
    }

    @Test
    public void can_remove_groups() throws Exception {
        Coach juan = new Coach("Juan");
        Coach alberto = new Coach("Alberto");
        Group group = juan.createGroup("EveCan");
        Group group2 = alberto.createGroup("Los PUMAS");

        assertThat(juan.groups().size(), is(1));

        juan.deleteGroup(group);
        assertThat(juan.groups().size(), is(0));

        juan.deleteGroup(group2);
        assertThat(alberto.groups().size(), is(1));

        alberto.deleteGroup(group2);
        assertThat(alberto.groups().size(), is(0));
    }

    @Test
    public void can_leave_from_the_group() throws Exception {
        Coach coach = new Coach("Mario");
        Group group = coach.createGroup("kirbyMakers");
        Athlete athlete = new Athlete("Yonay");

        coach.addUser(athlete).to(group);
        coach.leaves(group);

        assertThat(group.users().size(), is(1));
        assertThat(group.users().contains(athlete), is(true));
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
    public void can_remove_users_from_a_group() throws Exception {
        Coach juan = new Coach("Juan");
        Group group = juan.createGroup("EveCan");
        Athlete pepe = new Athlete("pepe");

        juan.addUser(pepe).to(group);
        assertThat(group.users().size(), is(2));
        assertThat(group.users().contains(pepe), is(true));
        assertThat(pepe.groups().size(), is(1));
        assertThat(pepe.groups().get(0), is(group));

        juan.removeUser(pepe).from(group);
        assertThat(group.users().size(), is(1));
        assertThat(group.users().contains(pepe), is(false));
        assertThat(pepe.groups().size(), is(0));
    }
}
