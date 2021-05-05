package ru.job4j.design.lsp.foodstore;

import java.util.Date;

public class Meat extends Food {

    public Meat(String name, Date created, Date expiry, double price) {
        super(name, created, expiry, price);
    }
}
