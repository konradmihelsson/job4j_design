package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(target.toFile())))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        Zip zip = new Zip();
        argZip.valid();
        zip.packFiles(search(argZip.directory(), argZip.exclude()), Path.of(argZip.output()));
    }

    public static List<Path> search(String rootDirectory, List<String> exclude) throws IOException {
        SearchFilesForZip searcher = new SearchFilesForZip(exclude);
        Files.walkFileTree(Path.of(rootDirectory), searcher);
        return searcher.getPaths();
    }
}
