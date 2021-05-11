package ru.job4j.design.isp.menu;

import java.util.*;

public class MenuSubmenuAdding implements Printable, Iterable<Element> {

    private List<Element> childElements;

    public MenuSubmenuAdding() {
        this.childElements = new ArrayList<>();
    }

    void addChildElement(Element element) {
        this.childElements.add(element);
    }

    @Override
    public void print() {
        this.childElements.forEach(Element::print);
    }

    boolean add(String parentName, Element child) {
        boolean result = false;
        for (Element element : this) {
            if (element.getName().equals(parentName)) {
                element.addChildElement(child);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Iterator<Element> iterator() {

        Stack<Element> elementStack = new Stack<>();
        elementStack.addAll(childElements);

        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !elementStack.empty();
            }

            @Override
            public Element next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Element result = elementStack.pop();
                for (Element element : result.getChildElements()) {
                    elementStack.push(element);
                }
                return result;
            }
        };
    }
}
