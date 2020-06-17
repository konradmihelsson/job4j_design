package ru.job4j.collection;

import java.util.Calendar;

public class UserOverrideHashCode {

    private String name;
    private int children;
    private Calendar birthday;

    public UserOverrideHashCode(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    @SuppressWarnings("CheckStyle")
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((children == 0) ? 0 : Integer.valueOf(children).hashCode());
        result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
        return result;
    }
}
