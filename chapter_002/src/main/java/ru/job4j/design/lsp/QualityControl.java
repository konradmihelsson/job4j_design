package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class QualityControl {

    private List<FoodStore> store;

    public QualityControl() {
        this.store = new ArrayList<>();
    }

    void add(FoodStore foodStore) {
        this.store.add(foodStore);
    }

    public void distribute() {
        List<Food> foods = new ArrayList<>();
        for (FoodStore foodStore : store) {
            List<Food> foodsInStore = foodStore.clear();
            foods.addAll(foodsInStore);
        }
        for (Food food : foods) {
            for (FoodStore foodStore : store) {
                if (foodStore.accept(food)) {
                    foodStore.add(food);
                    break;
                }
            }
        }
    }
}
