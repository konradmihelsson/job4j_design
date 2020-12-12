package ru.job4j.design.srp;

public interface OutputFormat {

    void addElement(String key);

    void addAttribute(String key, String value);

    void buildElement();

    String getContent();
}
