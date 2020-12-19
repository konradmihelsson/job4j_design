package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Trash implements FoodStore {

    private List<Food> storage;

    public Trash() {
        this.storage = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        this.storage.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return food.getExpiry().getTime() - new Date().getTime() < 0;
    }

    @Override
    public List<Food> clear() {
        List<Food> result = this.storage;
        this.storage = new ArrayList<>();
        return result;
    }
}
