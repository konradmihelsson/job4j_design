package ru.job4j.design.srp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class ReportEngineHRDpt extends ReportEngine {

    public ReportEngineHRDpt(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        Comparator<Employee> bySalary = Comparator.comparing(Employee::getSalary).reversed();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        ArrayList<Employee> toOutput = new ArrayList<>(super.store.findBy(filter));
        toOutput.sort(bySalary);
        for (Employee employee : toOutput) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
