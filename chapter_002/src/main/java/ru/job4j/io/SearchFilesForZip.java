package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

class SearchFilesForZip implements FileVisitor<Path> {

    SearchFilesForZip(List<String> exclude) {
        this.exclude = exclude;
    }

    private List<String> exclude;
    private List<Path> store = new ArrayList<>();

    List<Path> getPaths() {
        return this.store;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean isCorrect = true;
        for (String ext : this.exclude) {
            if (file.toFile().getName().endsWith(ext)) {
                isCorrect = false;
            }
        }
        if (isCorrect) {
            this.store.add(file);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }
}
