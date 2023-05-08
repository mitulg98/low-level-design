package org.example.builders;

import org.example.*;
import org.example.cars.Car;
import org.example.cars.ManualCar;

public class ManualCarBuilder implements Builder {
    private int seats;
    private CarType carType;
    private Engine engine;
    private Transmission transmission;
    private GPSNavigator gpsNavigator;
    private TripComputer tripComputer;
    @Override
    public ManualCarBuilder setCarType(CarType type) {
        this.carType = type;
        return this;
    }

    @Override
    public ManualCarBuilder setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    @Override
    public ManualCarBuilder setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public ManualCarBuilder setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    @Override
    public ManualCarBuilder setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
        return this;
    }

    @Override
    public ManualCarBuilder setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
        return this;
    }

    @Override
    public ManualCar getCar() {
        return new ManualCar(carType, engine, transmission, gpsNavigator, tripComputer, seats);
    }
}
