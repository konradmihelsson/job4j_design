package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {

        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(table().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String table() {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                result.append(i * j).append(" ");
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }
}
