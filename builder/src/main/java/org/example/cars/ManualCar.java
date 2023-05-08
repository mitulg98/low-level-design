package org.example.cars;

import org.example.*;

public class ManualCar extends Car{
    public ManualCar(CarType carType, Engine engine, Transmission transmission, GPSNavigator gpsNavigator, TripComputer tripComputer, int seats) {
        super(carType, engine, transmission, gpsNavigator, tripComputer, seats);
    }

    public void print() {
        System.out.println("Printing stuff about car");
    }
}
