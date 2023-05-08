package org.example.cars;

import org.example.*;

import java.util.Objects;

public abstract class Car {
    private final int seats;
    private final CarType carType;
    private final Engine engine;
    private final Transmission transmission;
    private final GPSNavigator gpsNavigator;
    private final TripComputer tripComputer;
    private double fuel = 0;

    public Car(CarType carType, Engine engine, Transmission transmission, GPSNavigator gpsNavigator, TripComputer tripComputer, int seats) {
        this.seats = seats;
        this.carType = carType;
        this.engine = engine;
        this.transmission = transmission;
        this.gpsNavigator = gpsNavigator;
        this.tripComputer = tripComputer;

        if(Objects.nonNull(this.tripComputer)) {
            this.tripComputer.setCar(this);
        }
    }

    public CarType getCarType() {
        return carType;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }

    public TripComputer getTripComputer() {
        return tripComputer;
    }

    public double getFuel() {
        return fuel;
    }

    public int getSeats() {
        return seats;
    }
}
