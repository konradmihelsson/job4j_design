package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {

    private User user1;
    private User user2;
    private User user3;
    private User user4;
    private UserStore store = new UserStore();

    @Before
    public void tune() {
        user1 = new User("Smart");
        user2 = new User("Great");
        user3 = new User("Capable");
        user4 = new User("Quick");
        store.add(user1);
        store.add(user2);
        store.add(user3);
    }

    @Test
    public void whenAddAndFindById() {
        assertThat(store.findById("Great").get(), is(user2));
    }

    @Test
    public void whenReplaceAndFind() {
        assertThat(store.replace("Great", user4), is(true));
        assertThat(store.findById("Quick").get(), is(user4));
    }

    @Test
    public void whenDeleteAndFindByNonexistentId() {
        assertThat(store.delete("Great"), is(true));
        assertThat(store.findById("Great").isPresent(), is(false));
    }

    @Test
    public void whenDeleteByNonexistentId() {
        assertThat(store.delete("Spectacular"), is(false));
    }
}
