package ru.job4j.design.srp;

public class OutputFormatHTML implements OutputFormat {

    private StringBuilder stringBuilder;

    public OutputFormatHTML() {
        this.stringBuilder = new StringBuilder("<html><head><title>HTML Report</title></head><body>");
    }

    @Override
    public void addElement(String key) {
        this.stringBuilder.append("<h4>")
                .append(key)
                .append("</h4>");
    }

    @Override
    public void addAttribute(String key, String value) {
        this.stringBuilder.append("<p>")
                .append(key)
                .append(":")
                .append(value)
                .append("</p>");
    }

    @Override
    public void buildElement() {

    }

    @Override
    public String getContent() {
        buildFooter();
        return this.stringBuilder.toString();
    }

    private void buildFooter() {
        this.stringBuilder.append("</body></html>");
    }
}
