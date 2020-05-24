package ru.job4j.streamapi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class ProfileTest {

    @Test
    public void consoleAddress() {
        List<Profile> list = List.of(new Profile(new Address("Dnipro", "Grushevsky", 11, 108)), new Profile(new Address("Lviv", "Petrovsky", 1, 10)));
        List<Address> addresses = new  ArrayList<>(List.of(new Address("Dnipro", "Grushevsky", 11, 108), new Address("Lviv", "Petrovsky", 1, 10)));
        assertThat(new Profiles().collect(list), is(addresses));
    }
}
