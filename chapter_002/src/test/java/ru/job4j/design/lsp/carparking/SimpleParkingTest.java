package ru.job4j.design.lsp.carparking;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class SimpleParkingTest {

    @Ignore ("Writing test before code")
    @Test
    public void whenAvailableParkingForCar() {
        Parking parking = new SimpleParking(1, 1);
        Vehicle simpleCar = new SimpleCar();
        assertTrue(parking.park(simpleCar));
    }

    @Ignore ("Writing test before code")
    @Test
    public void whenUnavailableParkingForCar() {
        Parking parking = new SimpleParking(1, 1);
        Vehicle simpleCar1 = new SimpleCar();
        Vehicle simpleCar2 = new SimpleCar();
        parking.park(simpleCar1);
        assertFalse(parking.park(simpleCar2));
    }

    @Ignore ("Writing test before code")
    @Test
    public void whenAvailableCommonParkingForTruck() {
        Parking parking = new SimpleParking(1, 1);
        Vehicle simpleTruck = new SimpleTruck();
        assertTrue(parking.park(simpleTruck));
    }

    @Ignore ("Writing test before code")
    @Test
    public void whenAvailableMultipleParkingForTruck() {
        Parking parking = new SimpleParking(3, 1);
        Vehicle simpleTruck1 = new SimpleTruck();
        Vehicle simpleTruck2 = new SimpleTruck();
        parking.park(simpleTruck1);
        assertTrue(parking.park(simpleTruck2));
    }

    @Ignore ("Writing test before code")
    @Test
    public void whenUnavailableParkingForTruck() {
        Parking parking = new SimpleParking(1, 1);
        Vehicle simpleTruck1 = new SimpleTruck();
        Vehicle simpleTruck2 = new SimpleTruck();
        parking.park(simpleTruck1);
        assertFalse(parking.park(simpleTruck2));
    }
}
