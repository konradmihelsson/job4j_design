package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Calendar;

public class OutputFormatTest {

    @Test
    public void whenOutputFormatXMLTest() {
        MemStore store = new MemStore();
        OutputFormat outputFormat = new OutputFormatXML();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportToFileFormat(store, outputFormat);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .append("<employee>")
                .append("<name>Ivan</name>")
                .append("<hired>").append(now.getTime()).append("</hired>")
                .append("<fired>").append(now.getTime()).append("</fired>")
                .append("<salary>100.0</salary>")
                .append("</employee>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenOutputFormatJSONTest() {
        MemStore store = new MemStore();
        OutputFormat outputFormat = new OutputFormatJSON();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportToFileFormat(store, outputFormat);
        StringBuilder expect = new StringBuilder()
                .append("{")
                .append("\"employee\": {")
                .append("\"name\":\"Ivan\",")
                .append("\"hired\":\"").append(now.getTime()).append("\",")
                .append("\"fired\":\"").append(now.getTime()).append("\",")
                .append("\"salary\":\"100.0\"")
                .append("}")
                .append("}");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenOutputFormatHTMLTest() {
        MemStore store = new MemStore();
        OutputFormat outputFormat = new OutputFormatHTML();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportToFileFormat(store, outputFormat);
        StringBuilder expect = new StringBuilder()
                .append("<html><head><title>HTML Report</title></head><body>")
                .append("<h4>employee</h4>")
                .append("<p>name:Ivan</p>")
                .append("<p>hired:").append(now.getTime()).append("</p>")
                .append("<p>fired:").append(now.getTime()).append("</p>")
                .append("<p>salary:100.0</p>")
                .append("</body></html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));

    }
}
