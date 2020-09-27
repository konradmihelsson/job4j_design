package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Search {

    public static void main(String[] args) throws IOException {
        if (args.length == 0 || args.length > 2) {
            throw new IllegalArgumentException("Wrong args. Usage: java -jar dir.jar ROOT_FOLDER FILE_EXTENSION");
        }
        Path start = Paths.get(args[0]);
        search(start, args[1]).forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
