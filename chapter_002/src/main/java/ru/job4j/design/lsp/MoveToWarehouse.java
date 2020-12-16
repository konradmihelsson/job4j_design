package ru.job4j.design.lsp;

public class MoveToWarehouse implements MoveStrategy {

    private FoodStore foodStore;

    public MoveToWarehouse(FoodStore warehouse) {
        this.foodStore = warehouse;
    }

    @Override
    public void action(Food food) {
        food.setFoodStore(this.foodStore);
    }
}
