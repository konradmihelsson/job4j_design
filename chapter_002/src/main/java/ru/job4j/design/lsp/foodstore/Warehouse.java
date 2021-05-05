package ru.job4j.design.lsp.foodstore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Warehouse implements FoodStore {

    public Warehouse() {
        this.storage = new ArrayList<>();
    }

    private List<Food> storage;

    @Override
    public void add(Food food) {
        this.storage.add(food);
    }

    @Override
    public boolean accept(Food food) {
        Date created = food.getCreated();
        Date expiry = food.getExpiry();
        Date today = new Date();
        float result =
                1 - (float) (expiry.getTime() - today.getTime())
                        / (float) (expiry.getTime() - created.getTime());
        return 0 <= result && result < 0.25;
    }

    @Override
    public List<Food> clear() {
        List<Food> result = this.storage;
        this.storage = new ArrayList<>();
        return result;
    }
}
