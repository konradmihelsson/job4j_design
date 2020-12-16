package ru.job4j.design.lsp;

public class MoveToShop implements MoveStrategy {

    private FoodStore foodStore;

    public MoveToShop(FoodStore shop) {
        this.foodStore = shop;
    }

    @Override
    public void action(Food food) {
        food.setFoodStore(this.foodStore);
    }
}
