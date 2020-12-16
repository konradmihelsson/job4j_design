package ru.job4j.design.lsp;

import java.util.Date;

public class ConverterExpireDateToFoodStore implements Converter {

    private Date today;

    public ConverterExpireDateToFoodStore(Date today) {
        this.today = today;
    }

    @Override
    public String convert(Food food) {

        String result = "Trash";
        int millisecondsPerDay = 1000 * 60 * 60 * 24;
        int percents = 100;
        Date expiry = food.getExpiry();
        int daysFromNowToTrash = (int) ((expiry.getTime() - this.today.getTime()) / millisecondsPerDay);
        int daysFromCreatedToTrash = (int) ((expiry.getTime() - food.getCreated().getTime()) / millisecondsPerDay);
        if (daysFromNowToTrash >= 0 && daysFromCreatedToTrash > 0) {
            int lifeRatio = percents - ((daysFromNowToTrash * percents) / daysFromCreatedToTrash);
            if (lifeRatio < 25) {
                result = "Warehouse";
            } else if (25 <= lifeRatio && lifeRatio < 75) {
                result = "Shop";
            } else if (75 <= lifeRatio) {
                result = "ShopDiscount";
            }
        }
        return result;
    }
}
