package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] partsOfLine = line.split(" ");
                String answerCode = partsOfLine[partsOfLine.length - 2];
                if (answerCode.equals("404")) {
                    result.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }

    public static void save(List<String> log, String fileName) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (String line : log) {
                out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
