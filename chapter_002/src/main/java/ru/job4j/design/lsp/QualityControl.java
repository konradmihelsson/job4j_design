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

    public void distribute(Food food) {
        for (FoodStore foodStore : store) {
            if (foodStore.accept(food)) {
                foodStore.add(food);
                break;
            }
        }
    }
}
