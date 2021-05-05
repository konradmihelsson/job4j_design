package ru.job4j.design.lsp.foodstore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Shop implements FoodStore {

    private List<Food> storage;

    public Shop() {
        this.storage = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        Date created = food.getCreated();
        Date expiry = food.getExpiry();
        Date today = new Date();
        if ((1 - (float) (expiry.getTime() - today.getTime()) / (float) (expiry.getTime() - created.getTime())) >= 0.75) {
            food.setDiscount((byte) 60);
        }
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
        return 0.25 <= result && result <= 1;
    }

    @Override
    public List<Food> clear() {
        List<Food> result = this.storage;
        this.storage = new ArrayList<>();
        return result;
    }
}
