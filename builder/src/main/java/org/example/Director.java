package org.example;

import org.example.builders.Builder;

public class Director {
    public void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.SPORTS).
                setSeats(2).
                setEngine(new Engine(3.0, 0)).
                setTransmission(Transmission.SEMI_AUTOMATIC).
                setTripComputer(new TripComputer()).
                setGPSNavigator(new GPSNavigator());
    }

    public void constructManualSUV(Builder builder) {
        builder.setCarType(CarType.SUV)
                .setSeats(4)
                .setEngine(new Engine(2.0, 0))
                .setTransmission(Transmission.MANUAL)
                .setTripComputer(new TripComputer())
                .setGPSNavigator(new GPSNavigator());
    }
}
