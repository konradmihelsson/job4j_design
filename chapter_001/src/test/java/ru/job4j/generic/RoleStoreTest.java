package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    private Role role1;
    private Role role2;
    private Role role3;
    private Role role4;
    private RoleStore store = new RoleStore();

    @Before
    public void tune() {
        role1 = new Role("Smart");
        role2 = new Role("Great");
        role3 = new Role("Capable");
        role4 = new Role("Quick");
        store.add(role1);
        store.add(role2);
        store.add(role3);
    }

    @Test
    public void whenFindById() {
        assertThat(store.findById("Great"), is(role2));
    }

    @Test
    public void whenReplaceAndFind() {
        assertThat(store.replace("Great", role4), is(true));
        assertThat(store.findById("Quick"), is(role4));
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

    @Test
    public void whenReplaceByNonexistentId() {
        assertThat(store.replace("Spectacular", role4), is(false));
    }
}
