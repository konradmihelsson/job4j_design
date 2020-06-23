package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMapTest {

    @Test
    public void whenAddThenGet() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        assertThat(map.insert(1, "first"), is(true));
        assertThat(map.get(1), is("first"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        assertThat(map.insert(1, "first"), is(true));
        assertThat(map.iterator().next().getValue(), is("first"));
    }

    @Test (expected = NullPointerException.class)
    public void whenGetEmpty() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.get(1);
    }

    @Test (expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.iterator().next();
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "first");
        Iterator<SimpleHashMap.Node<Integer, String>> it = map.iterator();
        map.insert(2, "second");
        it.next();
    }

    @Test
    public void whenIncreaseStoreSize() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "first");
        map.insert(2, "second");
        map.insert(3, "third");
        map.insert(4, "fourth");
        map.insert(5, "fifth");
        assertThat(map.get(5), is("fifth"));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenSameHash() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(0, "zero");
        map.insert(0, "zeroToo");
        Iterator<SimpleHashMap.Node<Integer, String>> it = map.iterator();
        it.next();
        it.next();
    }

    @Test
    public void whenDelete() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "first");
        map.insert(2, "second");
        assertThat(map.delete(2), is(true));
        assertThat(map.delete(2), is(false));
    }

    @Test
    public void whenAddNullKeyAndDeleteAll() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(null, "first");
        map.insert(null, "second");
        assertThat(map.get(null), is("first"));
        assertThat(map.delete(null), is(true));
        assertThat(map.iterator().hasNext(), is(false));
    }

    @Test (expected = NullPointerException.class)
    public void whenAddThenGetNullKey() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "first");
        map.get(null);
    }
}
