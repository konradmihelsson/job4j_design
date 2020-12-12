package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportToFileFormat implements Report {

    private Store store;
    private OutputFormat outputFormat;

    public ReportToFileFormat(Store store, OutputFormat outputFormat) {
        this.store = store;
        this.outputFormat = outputFormat;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        for (Employee employee : this.store.findBy(filter)) {
            outputFormat.addElement(employee.getClass().getSimpleName().toLowerCase());
            outputFormat.addAttribute("name", employee.getName());
            outputFormat.addAttribute("hired", employee.getHired().getTime().toString());
            outputFormat.addAttribute("fired", employee.getFired().getTime().toString());
            outputFormat.addAttribute("salary", String.valueOf(employee.getSalary()));
            outputFormat.buildElement();
        }
        return outputFormat.getContent();
    }
}
