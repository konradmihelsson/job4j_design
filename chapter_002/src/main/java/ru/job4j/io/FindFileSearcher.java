package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FindFileSearcher extends SimpleFileVisitor<Path> {
    PathMatcher matcher;
    List<Path> searchResult = new ArrayList<>();

    public FindFileSearcher(PathMatcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        if (exc instanceof AccessDeniedException) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        return super.visitFileFailed(file, exc);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        Path name = file.getFileName();
        if (matcher.matches(name)) {
            searchResult.add(file.normalize().toAbsolutePath());
        }
        return FileVisitResult.CONTINUE;
    }

    List<Path> getPaths() {
        return this.searchResult;
    }
}
