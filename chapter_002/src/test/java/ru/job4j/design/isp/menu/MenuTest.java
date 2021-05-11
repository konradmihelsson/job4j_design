package ru.job4j.design.isp.menu;

import static org.junit.Assert.*;
import org.junit.Test;

public class MenuTest {

    @Test
    public void whenTest() {
        MenuSubmenuAdding menu = new MenuSubmenuAdding();
        Element element1 = new Element("1");
        Element element2 = new Element("2");
        Element element3 = new Element("3");
        menu.addChildElement(element1);
        menu.addChildElement(element2);
        menu.addChildElement(element3);

        Element element11 = new Element("11");
        Element element12 = new Element("12");
        Element element13 = new Element("13");
        element1.addChildElement(element11);
        element1.addChildElement(element12);
        element1.addChildElement(element13);

        Element element21 = new Element("21");
        Element element22 = new Element("22");
        Element element23 = new Element("23");
        element2.addChildElement(element21);
        element2.addChildElement(element22);
        element2.addChildElement(element23);

        Element element31 = new Element("31");
        Element element32 = new Element("32");
        Element element33 = new Element("33");
        element3.addChildElement(element31);
        element3.addChildElement(element32);
        element3.addChildElement(element33);

        Element element111 = new Element("111");
        Element element112 = new Element("112");
        Element element113 = new Element("113");
        element11.addChildElement(element111);
        element11.addChildElement(element112);
        element11.addChildElement(element113);

        Element element777 = new Element("777");
        Element element888 = new Element("888");
        assertTrue(menu.add("112", element777));
        assertFalse(menu.add("555", element888));
    }
}
