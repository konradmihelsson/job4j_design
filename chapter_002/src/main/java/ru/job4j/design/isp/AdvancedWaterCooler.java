package ru.job4j.design.isp;

public class AdvancedWaterCooler implements WaterCooler {
    @Override
    public void pour() {
        System.out.println("Pour out");
    }

    @Override
    public void heatUp() {
        System.out.println("Heating");
    }

    @Override
    public void coolDown() {
        System.out.println("Cooling");
    }

    @Override
    public void waterLevelMeasure() {
        System.out.println("Measuring");
    }
}
