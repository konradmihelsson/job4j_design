package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenReportEngineDvlDptTest() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineDvlDpt(store);
        StringBuilder expect = new StringBuilder()
                .append("<html><head><title>HTML Report</title></head>")
                .append("<body><div>")
                .append("<h1>HTML Report</h1>")
                .append("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\"><tbody>")
                .append("<tr>")
                .append("<td>Name</td>")
                .append("<td>Hired</td>")
                .append("<td>Fired</td>")
                .append("<td>Salary</td>")
                .append("</tr>")
                .append("<tr>")
                .append("<td>Ivan</td>")
                .append("<td>").append(now).append("</td>")
                .append("<td>").append(now).append("</td>")
                .append("<td>100.0</td>")
                .append("</tr>")
                .append("</tbody></table></div></body></html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportEngineEconomicDptTest() {
        MemStore store = new MemStore();
        Converter converter = new ConverterSalaryTax();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineEconomicDpt(store, converter);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary w/o tax;")
                .append(System.lineSeparator())
                .append("Ivan;")
                .append(now).append(";")
                .append(now).append(";")
                .append("87.00;")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportEngineHRDptTest() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Igor", now, now, 200);
        store.add(worker);
        store.add(worker2);
        Report engine = new ReportEngineHRDpt(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append("Igor;")
                .append("200.0;")
                .append(System.lineSeparator())
                .append("Ivan;")
                .append("100.0;")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
