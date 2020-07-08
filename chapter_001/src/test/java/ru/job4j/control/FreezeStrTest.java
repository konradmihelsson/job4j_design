package ru.job4j.control;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class FreezeStrTest {

    @Test
    public void whenEq() {
        assertThat(FreezeStr.eq("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr.eq("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr.eq("heloo", "hello"), is(false));
    }

    @Test
    public void whenBothIsNull() {
        assertThat(FreezeStr.eq(null, null), is(true));
    }

    @Test
    public void whenOneIsNull() {
        assertThat(FreezeStr.eq(null, "heloo"), is(false));
    }

    @Test
    public void whenDifferentStringLength() {
        assertThat(FreezeStr.eq("hello", "helloooo"), is(false));
    }
}
