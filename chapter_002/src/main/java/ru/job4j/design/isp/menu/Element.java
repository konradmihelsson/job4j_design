package ru.job4j.design.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Element implements Printable, Active {

    private String name;

    private Element parent;

    private List<Element> childElements;

    public Element(String name) {
        this.name = name;
        childElements = new ArrayList<>();
    }

    void addChildElement(Element element) {
        element.parent = this;
        this.childElements.add(element);
    }

    public String getName() {
        return name;
    }

    public List<Element> getChildElements() {
        return childElements;
    }

    @Override
    public void doAction(Action action) {
        action.someAction();
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (Element element : childElements) {
            StringBuilder stringBuilder = new StringBuilder();
            Element parent = element.parent;
            while (parent != null) {
                stringBuilder.append("---");
                parent = parent.parent;
            }
            System.out.print(stringBuilder);
            element.print();
        }
    }
}
