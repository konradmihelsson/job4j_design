package ru.job4j.design.lsp.foodstore;

import java.util.List;

public interface FoodStore {

    void add(Food food);

    boolean accept(Food food);

    List<Food> clear();
}
