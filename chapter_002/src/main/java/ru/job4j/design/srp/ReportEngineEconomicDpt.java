package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportEngineEconomicDpt implements Report {

    private Store store;
    private Converter converter;

    public ReportEngineEconomicDpt(Store store, Converter converter) {
        this.store = store;
        this.converter = converter;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary w/o tax;")
                .append(System.lineSeparator());

        for (Employee employee : this.store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(this.converter.convert(employee.getSalary())).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
