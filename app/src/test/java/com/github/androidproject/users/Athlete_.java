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

}
