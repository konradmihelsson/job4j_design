package ru.job4j.control;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Merging {
    public static Map<String, Set<String>> mergeUsers(Map<String, Set<String>> input) {

        Map<String, String> temp = new HashMap<>();
        Map<String, Set<String>> result = new HashMap<>(input);
        for (String user : input.keySet()) {
            Set<String> emails = input.get(user);
            String tempUser = null;
            for (String email : emails) {
                String existingUser = temp.put(email, user);
                if (existingUser != null) {
                    tempUser = existingUser;
                }
            }
            if (tempUser != null) {
                result.get(tempUser).addAll(emails);
                result.remove(user);
            }
        }
        return result;
    }
}
