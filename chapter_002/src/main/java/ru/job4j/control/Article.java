package ru.job4j.control;

import java.util.Arrays;
import java.util.HashMap;

public class Article {

    public static boolean generateBy(String origin, String line) {
        boolean result = true;
        HashMap<String, Integer> orig = new HashMap<>();
        Arrays.stream(origin
                .replaceAll("\\pP", "")
                .trim().split(" "))
                .forEach(s -> {
                    Integer num = orig.get(s);
                    if (num == null) {
                        num = 0;
                    }
                    orig.put(s, num + 1);
                });

        String[] lin = line.trim().split(" ");
        for (String s : lin) {
            Integer num = orig.get(s);
            if (num == null || num == 0) {
                result = false;
                break;
            } else {
                orig.put(s, num - 1);
            }
        }
        return result;
    }
}
