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
        boolean result = false;
        int size = vehicle.getSize();
        if (size > 1) {
            if (numOfTrucks > 0) {
                numOfTrucks--;
                result = true;
            } else {
                if (numOfCars >= size) {
                    numOfCars = numOfCars - size;
                    result = true;
                }
            }
        } else {
            if (numOfCars >= size) {
                numOfCars = numOfCars - size;
                result = true;
            }
        }
        return result;
    }
}
