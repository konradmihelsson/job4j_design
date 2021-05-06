package ru.job4j.design.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Printable {

    private List<Element> childElements;

    public Menu() {
        this.childElements = new ArrayList<>();
    }

    void addChildElement(Element element) {
        this.childElements.add(element);
    }

    @Override
    public void print() {
        this.childElements.forEach(Element::print);
    }
}
