package ru.job4j.control;

import java.util.List;

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
