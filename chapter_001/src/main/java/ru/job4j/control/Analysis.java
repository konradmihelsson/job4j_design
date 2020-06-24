package ru.job4j.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analysis {

    public Info diff(List<User> previous, List<User> current) {
        Info result = new Info();
        int unchanged = 0;

        for (User userPrev : previous) {
            for (User userCurr : current) {
                if (userPrev.id == userCurr.id) {
                    if (userPrev.name.equals(userCurr.name)) {
                        unchanged++;
                    } else {
                        result.changed++;
                    }
                    break;
                }
            }
        }

        result.added = current.size() - unchanged - result.changed;
        result.deleted = previous.size() - unchanged - result.changed;

        return result;
    }

    public Info diffAnother(List<User> previous, List<User> current) {
        Info result = new Info();
        Map<Integer, String> temp = new HashMap<>();
        int unChanged = 0;

        for (User user : previous) {
            temp.put(user.id, user.name);
        }
        for (User user : current) {
            if (user.name.equals(temp.put(user.id, user.name))) {
                unChanged++;
            }
        }
        result.added = temp.size() - previous.size();
        result.deleted = temp.size() - current.size();
        result.changed = current.size() - result.added - unChanged;

        return result;
    }

    public static class User {
        int id;
        String name;
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}
