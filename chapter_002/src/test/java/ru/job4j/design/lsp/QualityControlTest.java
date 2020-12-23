package ru.job4j.design.lsp;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.*;

public class QualityControlTest {

    @Test
    public void whenTest() {

        FoodStore warehouse = new Warehouse();
        FoodStore shop = new Shop();
        FoodStore trash = new Trash();

        Date today = new Date();
        long msPerDay = 1000 * 60 * 60 * 24;

        Food bananaE = new Banana("Ecuador banana", new Date(today.getTime() - (14 * msPerDay)),
                new Date(today.getTime() + (23 * msPerDay)), 90);
        Food bananaU = new Banana("Uruguay banana", new Date(today.getTime() - (45 * msPerDay)),
                new Date(today.getTime() + (5 * msPerDay)), 100);
        Food meatC = new Meat("Cow meat", new Date(today.getTime() - (30 * msPerDay)),
                new Date(today.getTime() - (2 * msPerDay)), 500);
        Food meatL = new Meat("Lamb meat", new Date(today.getTime() - (2 * msPerDay)),
                new Date(today.getTime() + (15 * msPerDay)), 600);

        QualityControl qualityControl = new QualityControl();

        qualityControl.add(warehouse);
        qualityControl.add(shop);
        qualityControl.add(trash);

        qualityControl.distribute(bananaE);
        qualityControl.distribute(bananaU);
        qualityControl.distribute(meatC);
        qualityControl.distribute(meatL);

        assertThat(bananaU.getDiscountedPrice(), is(40.0));
        assertThat(warehouse.clear(), containsInAnyOrder(meatL));
        assertThat(shop.clear(), containsInAnyOrder(bananaE, bananaU));
        assertThat(trash.clear(), containsInAnyOrder(meatC));
    }
}
