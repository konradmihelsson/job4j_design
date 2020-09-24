package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./src/test/resources/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.username"),
                is("postgres")
        );
    }

    @Test
    public void whenPairWithComment() {
        String path = "./src/test/resources/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.testcommentedline"),
                isEmptyOrNullString()
        );
    }

    @Test
    public void whenEmptyLine() {
        String path = "./src/test/resources/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value(""),
                isEmptyOrNullString()
        );
    }

    @Test
    public void whenPairWithoutCommentButLineWithSpaces() {
        String path = "./src/test/resources/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.driver_class"),
                is("org.postgresql.Driver")
        );
    }
}
