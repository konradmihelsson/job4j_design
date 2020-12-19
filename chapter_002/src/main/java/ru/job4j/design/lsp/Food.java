package ru.job4j.design.lsp;

import java.util.Date;

public class Food {

    private String name;
    private Date created;
    private Date expiry;
    private double price;
    private byte discount;

    public Food(String name, Date created, Date expiry, double price) {
        this.name = name;
        this.created = created;
        this.expiry = expiry;
        this.price = price;
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

    public void setDiscount(byte discount) {
        this.discount = discount;
    }
}
