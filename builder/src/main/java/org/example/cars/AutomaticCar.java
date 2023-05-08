package org.example.cars;

import org.example.*;

public class AutomaticCar extends Car {
    public AutomaticCar(CarType carType, Engine engine, Transmission transmission, GPSNavigator gpsNavigator, TripComputer tripComputer, int seats) {
        super(carType, engine, transmission, gpsNavigator, tripComputer, seats);
    }
}
