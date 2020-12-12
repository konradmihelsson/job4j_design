package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportEngineDvlDpt implements Report {

    private Store store;

    public ReportEngineDvlDpt(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html><head><title>HTML Report</title></head>")
                .append("<body><div>")
                .append("<h1>HTML Report</h1>")
                .append("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\"><tbody>")
                .append("<tr>")
                .append("<td>Name</td>")
                .append("<td>Hired</td>")
                .append("<td>Fired</td>")
                .append("<td>Salary</td>")
                .append("</tr>");
        for (Employee employee : this.store.findBy(filter)) {
            text.append("<tr>")
                    .append("<td>").append(employee.getName()).append("</td>")
                    .append("<td>").append(employee.getHired()).append("</td>")
                    .append("<td>").append(employee.getFired()).append("</td>")
                    .append("<td>").append(employee.getSalary()).append("</td>")
                    .append("</tr>");
        }
        text.append("</tbody></table></div></body></html>");
        return text.toString();
    }
}
