package ru.job4j.design.srp;

import java.text.DecimalFormat;
import java.util.function.Predicate;

public abstract class ReportEngine {

    public Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public abstract String generate(Predicate<Employee> filter);
}
