package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AnalizyTestTempFolder {

    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Test
    public void whenPairWithoutComment() throws IOException {
        String sourceFile = "./src/test/resources/analizy_server.log";
        File fileForWrite = tmpFolder.newFile("analized_in_temp_folder.log");
        String targetFile = fileForWrite.getAbsolutePath();
        Analizy analizy = new Analizy();
        analizy.unavailable(sourceFile, targetFile);
        String expected = "10:58:01;10:59:01;11:01:02;11:02:02;";
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(targetFile))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is(expected));
    }
}
