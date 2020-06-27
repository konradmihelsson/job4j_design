package ru.job4j.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean result = false;
        if (left == null && right == null) {
            result = true;
        } else if (left != null && right != null) {
            List<Character> leftList = new ArrayList<>();
            List<Character> rightList = new ArrayList<>();
            for (char ch : left.toCharArray()) {
                leftList.add(ch);
            }
            for (char ch : right.toCharArray()) {
                rightList.add(ch);
            }
            Collections.sort(leftList);
            Collections.sort(rightList);
            result = leftList.equals(rightList);
        }
        return result;
    }
}
