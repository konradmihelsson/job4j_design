package ru.job4j.gc;

import java.lang.ref.SoftReference;
import java.util.HashMap;

public abstract class SoftCache {

    private HashMap<Object, SoftReference<Object>> store = new HashMap<>();

    public Object get(Object key) {
        Object result;
        SoftReference softReference = this.store.get(key);
        if (softReference == null) {
            result = load(key);
            this.store.put(key, new SoftReference<>(result));
        } else {
            result = softReference.get();
        }
        return result;
    }

    abstract Object load(Object key);
}
