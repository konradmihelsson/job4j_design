package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportEngineEconomicDpt extends ReportEngine {

    private static final float INCOME_TAX = 0.13f;

    public ReportEngineEconomicDpt(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary w/o tax;")
                .append(System.lineSeparator());

        for (Employee employee : super.store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(String.format("%.2f", employee.getSalary() * (1 - INCOME_TAX))).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
