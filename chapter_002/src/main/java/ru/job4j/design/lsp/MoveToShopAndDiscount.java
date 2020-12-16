package ru.job4j.design.lsp;

public class MoveToShopAndDiscount implements MoveStrategy {

    private FoodStore foodStore;
    private final byte discount = 60;

    public MoveToShopAndDiscount(FoodStore shop) {
        this.foodStore = shop;
    }

    @Override
    public void action(Food food) {
        food.setFoodStore(this.foodStore);
        food.setDiscount(discount);
    }
}
