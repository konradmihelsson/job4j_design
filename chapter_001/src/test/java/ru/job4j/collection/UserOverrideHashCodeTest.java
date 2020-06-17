package ru.job4j.collection;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserOverrideHashCodeTest {

    @Test
    public void whenOverrideHashCode() {
        Map<UserOverrideHashCode, Object> store = new HashMap<>();
        UserOverrideHashCode first = new UserOverrideHashCode("John", 2, new GregorianCalendar(1980, Calendar.JANUARY, 1));
        UserOverrideHashCode second = new UserOverrideHashCode("John", 2, new GregorianCalendar(1980, Calendar.JANUARY, 1));
        store.put(first, 1);
        store.put(second, 2);
        assertThat(store.get(first), is(1));
        System.out.println(store);
    }
}
