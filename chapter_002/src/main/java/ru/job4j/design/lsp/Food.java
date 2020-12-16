package ru.job4j.design.lsp;

import java.util.Date;

public class Food {

    private String name;
    private Date created;
    private Date expiry;
    private double price;
    private byte discount;

    private FoodStore foodStore;

    public Food(String name, Date created, Date expiry, double price, FoodStore foodStore) {
        this.name = name;
        this.created = created;
        this.expiry = expiry;
        this.price = price;
        this.foodStore = foodStore;
    }

    public Date getExpiry() {
        return expiry;
    }

    public Date getCreated() {
        return created;
    }

    public double getDiscountedPrice() {
        return price * (100 - this.discount) / 100;
    }

    public FoodStore getFoodStore() {
        return foodStore;
    }

    public void setDiscount(byte discount) {
        this.discount = discount;
    }

    public void setFoodStore(FoodStore foodStore) {
        this.foodStore = foodStore;
    }
}
