package ru.job4j.design.lsp;

public class MoveToTrash implements MoveStrategy {

    private FoodStore foodStore;

    public MoveToTrash(FoodStore trash) {
        this.foodStore = trash;
    }

    @Override
    public void action(Food food) {
        food.setFoodStore(this.foodStore);
    }
}
