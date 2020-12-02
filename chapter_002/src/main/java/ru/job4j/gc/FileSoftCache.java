package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.FileReader;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileSoftCache extends SoftCache {

    @Override
    Object load(Object key) {
        String sourceFilePath;
        if (key instanceof String) {
            sourceFilePath = (String) key;
        } else {
            throw new UnsupportedOperationException("key must be filepath string");
        }
        StringBuilder result = new StringBuilder();
        String ls = System.getProperty("line.separator");
        try (BufferedReader read = new BufferedReader(new FileReader(sourceFilePath, UTF_8))) {
            read.lines().forEach(s -> result.append(s).append(ls));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        FileSoftCache fileSoftCache = new FileSoftCache();
        System.out.println(fileSoftCache.get("404.txt"));
        System.out.println(fileSoftCache.get("result.txt"));
        System.out.println(fileSoftCache.get("README.md"));
    }
}
