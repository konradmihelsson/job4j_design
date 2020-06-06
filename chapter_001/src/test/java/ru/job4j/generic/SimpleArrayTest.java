package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenAddSetAndGetSameValue() {
        SimpleArray<String> data = new SimpleArray<>(5);
        data.add("zero");
        data.add("first");
        data.add("second");
        data.add("third");
        assertThat(data.get(2), is("second"));
        data.set(2, "BIG SECOND");
        assertThat(data.get(2), is("BIG SECOND"));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenCreateAndFillOverSize() {
        SimpleArray<Integer> data = new SimpleArray<>(3);
        data.add(1);
        data.add(1);
        data.add(1);
        data.add(1);
    }

    @Test
    public void whenRemoveElements() {
        SimpleArray<Integer> data = new SimpleArray<>(10);
        data.add(0);
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        data.add(5);
        data.add(6);
        data.add(7);
        assertThat(data.get(2), is(2));
        assertThat(data.get(5), is(5));
        data.remove(4);
        data.remove(2);
        data.remove(2);
        assertThat(data.get(2), is(5));
        assertThat(data.get(5), is(nullValue()));
    }

    @Test
    public void whenIteratorTestNoSuchElementEndOfData() {
        SimpleArray<Integer> data = new SimpleArray<>(3);
        data.add(0);
        data.add(1);
        data.add(2);
        Iterator iter = data.iterator();
        assertThat(iter.next(), is(0));
        iter.next();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(2));
        assertThat(iter.hasNext(), is(false));
    }

    @Test
    public void whenIteratorTestNoSuchElementNullElements() {
        SimpleArray<Integer> data = new SimpleArray<>(10);
        data.add(0);
        data.add(1);
        data.add(2);
        Iterator iter = data.iterator();
        iter.next();
        iter.next();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(2));
        assertThat(iter.hasNext(), is(false));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenIteratorTestNoSuchElementException() {
        SimpleArray<Integer> data = new SimpleArray<>(10);
        data.add(0);
        data.add(1);
        data.add(2);
        Iterator iter = data.iterator();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
    }
}
