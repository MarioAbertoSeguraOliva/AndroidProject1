package com.github.androidproject.users;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class Athlete_ {
    @Test
    public void can_change_profile_name() throws Exception {
        Coach coach = new Coach("Jonaii");
        Group group = coach.createGroup("piratas");
        Athlete athlete = new Athlete("aleman");
        coach.addUser(athlete).to(group);

        assertThat(athlete.name(), is("aleman"));
        athlete.name("Angelo");
        assertThat(athlete.name(), is("Angelo"));
    }

    @Test
    public void can_leave_from_the_group() throws Exception {
        Coach coach = new Coach("Mario");
        Group group = coach.createGroup("kirbyMakers");
        Athlete athlete = new Athlete("Yonay");

        coach.addUser(athlete).to(group);
        athlete.leaves(group);

        assertThat(group.users().size(), is(1));
        assertThat(group.users().contains(coach), is(true));
    }

    @Test
    public void can_send_message_to_group() throws Exception {
        Coach coach = new Coach("Juan Carlos");
        Group group = coach.createGroup("Buenas tardes tardes");
        Athlete athlete = new Athlete("Jose");
        Athlete athlete2 = new Athlete("Mario");
        Athlete athlete3 = new Athlete("Alberto");

        coach.addUser(athlete).to(group);
        coach.addUser(athlete2).to(group);
        coach.addUser(athlete3).to(group);
        assertThat(group.users().size(), is(4));

        athlete.sendMessage("No quiero estudiar redes").to(group.chat());
        assertThat(group.chat().messages().size(), is(1));
        assertThat(group.chat().messages().get(0).sender(), CoreMatchers.<User>is(athlete));
        assertThat(group.chat().messages().get(0).content(), is("No quiero estudiar redes"));

        athlete2.sendMessage("Estamos haciendo una practica que es imposible").to(group.chat());
        assertThat(group.chat().messages().size(), is(2));
        assertThat(group.chat().messages().get(1).sender(), CoreMatchers.<User>is(athlete2));
        assertThat(group.chat().messages().get(1).content(), is("Estamos haciendo una practica que es imposible"));

        athlete.sendMessage("Pues me voy a comer").to(group.chat());
        assertThat(group.chat().messages().size(), is(3));
        athlete3.sendMessage("Espera!!").to(group.chat());
        assertThat(group.chat().messages().size(), is(4));

        assertThat(group.chat().messages().get(2).sender(), CoreMatchers.<User>is(athlete));
        assertThat(group.chat().messages().get(2).content(), is("Pues me voy a comer"));
        assertThat(group.chat().messages().get(3).sender(), CoreMatchers.<User>is(athlete3));
        assertThat(group.chat().messages().get(3).content(), is("Espera!!"));

        assertThat(group.users().size(), is(4));
    }

}
