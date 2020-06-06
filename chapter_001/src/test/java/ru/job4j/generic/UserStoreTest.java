package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {

    private User user1 = new User("Smart");
    private User user2 = new User("Great");
    private User user3 = new User("Capable");
    private User user4 = new User("Quick");

    private UserStore store = new UserStore();

    @Before
    public void tune() {
        store.add(user1);
        store.add(user2);
        store.add(user3);
    }

    @Test
    public void whenAddAndFindById() {
        assertThat(store.findById("Great"), is(user2));
    }

    @Test
    public void whenReplaceAndFind() {
        assertThat(store.replace("Great", user4), is(true));
        assertThat(store.findById("Quick"), is(user4));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenDeleteAndFindByNonexistentId() {
        assertThat(store.delete("Great"), is(true));
        assertThat(store.findById("Great"), is(false));
    }

    @Test
    public void whenDeleteByNonexistentId() {
        assertThat(store.delete("Spectacular"), is(false));
    }
}
