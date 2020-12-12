package ru.job4j.design.srp;

public class OutputFormatJSON implements OutputFormat {

    private StringBuilder stringBuilder;

    public OutputFormatJSON() {
        this.stringBuilder = new StringBuilder("{");
    }

    @Override
    public void addElement(String key) {
        this.stringBuilder.append("\"")
                .append(key)
                .append("\": {");
    }

    @Override
    public void addAttribute(String key, String value) {
        this.stringBuilder.append("\"")
                .append(key)
                .append("\":\"")
                .append(value)
                .append("\",");
    }

    @Override
    public void buildElement() {
        this.stringBuilder = new StringBuilder(trimComma(this.stringBuilder.toString()) + "}");
    }

    @Override
    public String getContent() {
        buildFooter();
        return this.stringBuilder.toString();
    }

    private void buildFooter() {
        this.stringBuilder.append("}");
    }

    private String trimComma(String str) {
        if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == ',') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
