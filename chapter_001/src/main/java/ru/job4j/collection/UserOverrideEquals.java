package ru.job4j.collection;

import java.util.Calendar;

public class UserOverrideEquals {

    private String name;
    private int children;
    private Calendar birthday;

    public UserOverrideEquals(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @SuppressWarnings("CheckStyle")
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserOverrideEquals)) {
            return false;
        }
        UserOverrideEquals user = (UserOverrideEquals) obj;
        return user.name.equals(this.name) && user.children == this.children
                && user.birthday.equals(this.birthday);
    }
}
