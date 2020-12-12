package ru.job4j.design.srp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class ReportEngineHRDpt implements Report {

    private Store store;

    public ReportEngineHRDpt(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        Comparator<Employee> bySalary = Comparator.comparing(Employee::getSalary).reversed();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        ArrayList<Employee> toOutput = new ArrayList<>(this.store.findBy(filter));
        toOutput.sort(bySalary);
        for (Employee employee : toOutput) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
