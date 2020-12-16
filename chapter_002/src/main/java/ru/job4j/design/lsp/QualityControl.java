package ru.job4j.design.lsp;

import java.util.List;
import java.util.Map;

public class QualityControl implements Runnable {

    private List<Food> store;
    private Map<String, MoveStrategy> strategyMap;
    private Converter converter;

    public QualityControl(List<Food> store, Map<String, MoveStrategy> strategyMap, Converter converter) {
        this.store = store;
        this.strategyMap = strategyMap;
        this.converter = converter;
    }

    public void updateFoodStore(Food food) {
        strategyMap.getOrDefault(converter.convert(food), strategyMap.get("Trash")).action(food);
    }

    @Override
    public void run() {
        store.forEach(this::updateFoodStore);
    }
}
