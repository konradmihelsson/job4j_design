package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {

    @Test
    public void whenPairWithoutComment() {
        String sourceFile = "./src/test/resources/analizy_server.log";
        String targetFile = "./src/test/resources/analized.log";
        Analizy analizy = new Analizy();
        analizy.unavailable(sourceFile, targetFile);
        String expected;
        try (BufferedReader read = new BufferedReader(new FileReader(targetFile))) {
            expected = read.readLine();
            assertThat(
                    expected,
                    is("10:58:01;10:59:01;")
            );
            expected = read.readLine();
            assertThat(
                    expected,
                    is("11:01:02;11:02:02;")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
