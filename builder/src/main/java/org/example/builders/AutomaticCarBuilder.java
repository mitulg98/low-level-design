package org.example.builders;

import org.example.*;
import org.example.cars.AutomaticCar;
import org.example.cars.Car;
import org.example.cars.ManualCar;

public class AutomaticCarBuilder implements Builder {
    private int seats;
    private CarType carType;
    private Engine engine;
    private Transmission transmission;
    private GPSNavigator gpsNavigator;
    private TripComputer tripComputer;

    @Override
    public AutomaticCarBuilder setCarType(CarType type) {
        this.carType = type;
        return this;
    }

    @Override
    public AutomaticCarBuilder setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    @Override
    public AutomaticCarBuilder setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public AutomaticCarBuilder setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    @Override
    public AutomaticCarBuilder setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
        return this;
    }

    @Override
    public AutomaticCarBuilder setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
        return this;
    }

    @Override
    public AutomaticCar getCar() {
        return new AutomaticCar(carType, engine, transmission, gpsNavigator, tripComputer, seats);
    }

}
