package ru.job4j.design.lsp;

import java.util.Date;

public class Meat extends Food {

    public Meat(String name, Date created, Date expiry, double price, FoodStore foodStore) {
        super(name, created, expiry, price, foodStore);
    }
}