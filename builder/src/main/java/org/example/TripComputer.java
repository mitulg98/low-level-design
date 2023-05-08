package org.example;

import org.example.cars.Car;

public class TripComputer {
    private Car car;

    public void showFuelLevel() {
        System.out.println("Fuel level : " + car.getFuel());
    }

    public void showStatus() {
        if(car.getEngine().isStarted()) {
            System.out.println("Car is running.");
        } else {
            System.out.println("Car is stationary.");
        }
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
