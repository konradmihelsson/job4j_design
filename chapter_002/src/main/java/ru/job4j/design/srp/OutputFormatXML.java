package ru.job4j.design.srp;

public class OutputFormatXML implements OutputFormat {

    private StringBuilder stringBuilder;
    private String elementKey;

    public OutputFormatXML() {
        this.stringBuilder = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    }

    @Override
    public void addElement(String key) {
        stringBuilder.append("<")
                .append(key)
                .append(">");
        this.elementKey = key;
    }

    @Override
    public void addAttribute(String key, String value) {
        stringBuilder.append("<")
                .append(key)
                .append(">")
                .append(value)
                .append("</")
                .append(key)
                .append(">");
    }

    @Override
    public void buildElement() {
        stringBuilder.append("</")
                .append(this.elementKey)
                .append(">");
    }

    @Override
    public String getContent() {
        return this.stringBuilder.toString();
    }
}
