package ru.job4j.control;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean result = false;
        if (left == null && right == null) {
            result = true;
        } else if (left != null && right != null && left.length() == right.length()) {
            Map<Character, Integer> leftStrChars = new HashMap<>();
            for (Character c : left.toCharArray()) {
                leftStrChars.merge(c, 1, Integer::sum);
            }
            for (Character c : right.toCharArray()) {
                Integer numOfChar = leftStrChars.get(c);
                if (numOfChar == null) {
                    break;
                } else if (numOfChar > 1) {
                    leftStrChars.put(c, numOfChar - 1);
                } else {
                    leftStrChars.remove(c);
                }
            }
            result = leftStrChars.isEmpty();
        }
        return result;
    }
}
