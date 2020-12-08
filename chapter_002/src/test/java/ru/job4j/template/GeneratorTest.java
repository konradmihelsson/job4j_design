package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GeneratorTest {

    public Generator generator;

    public GeneratorTest(Generator generator) {
        this.generator = generator;
    }

    @Ignore ("It use to study only")
    @Test
    public void whenAllIsOK() {
        Map<String, String> store = new HashMap<>();
        store.put("name", "Petr Arsentev");
        store.put("subject", "you");
        assertThat("I am a Petr Arsentev, Who are you? ",
                is(this.generator.produce("I am a ${name}, Who are ${subject}? ", store)));
    }

    @Ignore ("It use to study only")
    @Test (expected = NoSuchElementException.class)
    public void whenNotAvailableKeysInStore() {
        Map<String, String> store = new HashMap<>();
        store.put("name", "Petr Arsentev");
        store.put("subject", "you");
        assertThat("My name is Petr Arsentev, I'm Java tutor. Who are you? ",
                is(this.generator
                        .produce("My name is ${name}, I'm ${occupation}. Who are ${subject}? ", store)));
    }

    @Ignore ("It use to study only")
    @Test (expected = Exception.class)
    public void whenExcessKeysInStore() {
        Map<String, String> store = new HashMap<>();
        store.put("name", "Petr Arsentev");
        store.put("subject", "you");
        store.put("occupation", "Java tutor");
        assertThat("I am a Petr Arsentev, Who are you? ",
                is(this.generator
                        .produce("I am a ${name}, Who are ${subject}? ", store)));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                new Object[]{new WildGenerator()},
                new Object[]{new TamedGenerator()}
        );
    }
}
