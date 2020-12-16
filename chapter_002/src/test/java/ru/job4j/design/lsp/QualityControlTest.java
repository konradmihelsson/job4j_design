package ru.job4j.design.lsp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import java.util.*;

public class QualityControlTest {

    @Test
    public void whenTest() {

        FoodStore warehouse = new Warehouse();
        FoodStore shop = new Shop();
        FoodStore trash = new Trash();

        Food bananaE = new Banana("Equador banana", new Date(120, 11, 1),
                new Date(121, 0, 7), 90, warehouse);
        Food bananaU = new Banana("Uruguay banana", new Date(120, 10, 1),
                new Date(120, 11, 20), 100, warehouse);
        Food meatC = new Meat("Cow meat", new Date(120, 10, 15),
                new Date(120, 11, 13), 600, warehouse);
        Food meatL = new Meat("Lamb meat", new Date(120, 11, 14),
                new Date(120, 11, 30), 600, shop);

        List<Food> foodStore = new ArrayList<>(Arrays.asList(bananaE, bananaU, meatC, meatL));

        Map<String, MoveStrategy> strategyMap = new TreeMap<>();
        MoveStrategy toWarehouse = new MoveToWarehouse(warehouse);
        MoveStrategy toShop = new MoveToShop(shop);
        MoveStrategy toShopAndDiscount = new MoveToShopAndDiscount(shop);
        MoveStrategy toTrash = new MoveToTrash(trash);
        strategyMap.put("Warehouse", toWarehouse);
        strategyMap.put("Shop", toShop);
        strategyMap.put("ShopDiscount", toShopAndDiscount);
        strategyMap.put("Trash", toTrash);

        Date today = new Date(120, 11, 15);
        Converter converter = new ConverterExpireDateToFoodStore(today);

        QualityControl qualityControl = new QualityControl(foodStore, strategyMap, converter);
        qualityControl.run();

        assertThat(bananaE.getFoodStore(), is(shop));

        assertThat(bananaU.getFoodStore(), is(shop));
        assertThat(bananaU.getDiscountedPrice(), is(40.0));

        assertThat(meatC.getFoodStore(), is(trash));

        assertThat(meatL.getFoodStore(), is(warehouse));
    }
}