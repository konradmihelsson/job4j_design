package ru.job4j.design.lsp.carparking;

public class SimpleParking implements Parking {

    private int numOfCars;
    private int numOfTrucks;

    public SimpleParking(int numOfCars, int numOfTrucks) {
        this.numOfCars = numOfCars;
        this.numOfTrucks = numOfTrucks;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        return false;
    }
}
