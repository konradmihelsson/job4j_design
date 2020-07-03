package ru.job4j.control;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Merging {
    public static Map<String, Set<String>> mergeUsers(Map<String, Set<String>> input) {

        Map<String, String> temp = new TreeMap<>();
        Map<String, Set<String>> result = new TreeMap<>(input);
        for (Map.Entry<String, Set<String>> pair : input.entrySet()) {
            String user = pair.getKey();
            Set<String> emails = pair.getValue();
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
