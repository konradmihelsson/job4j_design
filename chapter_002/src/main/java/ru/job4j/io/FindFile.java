package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FindFile implements Runnable {

    private final Map<String, Consumer<String>> actions = new HashMap<>();
    private FindFileSearcher findFileSearcher;
    private Path rootDirectory;
    private String fileToWrite;

    public FindFile() {
        this.actions.put("-f", this::findByName);
        this.actions.put("-m", this::findByMask);
        this.actions.put("-r", this::findByRegularExpression);
    }

    private void findByMask(String userInput) {
        this.findFileSearcher = new FindFileSearcher(FileSystems.getDefault()
                .getPathMatcher("glob:" + userInput)) {
        };
    }

    private void findByRegularExpression(String userInput) {
        this.findFileSearcher = new FindFileSearcher(FileSystems.getDefault()
                .getPathMatcher("regex:" + userInput)) {
        };
    }

    private void findByName(String userInput) {
        this.findFileSearcher = new FindFileSearcher(p -> p.normalize().toString().equals(userInput)) {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                Path name = file.getFileName();
                if (matcher.matches(name)) {
                    searchResult.add(file.normalize().toAbsolutePath());
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }
        };
    }

    public static void main(String[] args) {
        FindFileArgsCheck findFileArgsCheck = new FindFileArgsCheck(args);
        findFileArgsCheck.validation();
        FindFile findFile = new FindFile();
        findFile.rootDirectory = Paths.get(findFileArgsCheck.rootDirectory());
        findFile.fileToWrite = findFileArgsCheck.getOutput();
        findFile.actions.getOrDefault(findFileArgsCheck.getOpt(), findFile::findByName)
                .accept(findFileArgsCheck.getCriterion());
        findFile.run();
    }

    @Override
    public void run() {
        try {
            Files.walkFileTree(this.rootDirectory, this.findFileSearcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeData(this.findFileSearcher.getPaths(), this.fileToWrite);
    }

    private void writeData(List<Path> linesForWrite, String outputFileName) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream(outputFileName)), true, UTF_8)) {
            linesForWrite.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
