package ru.job4j.design.srp;

import java.util.Locale;

public class ConverterSalaryTax implements Converter {

    private static final double INCOME_TAX = 0.13;

    @Override
    public String convert(double value) {
        return String.format(Locale.ENGLISH, "%.2f", value * (1 - INCOME_TAX));
    }
}
