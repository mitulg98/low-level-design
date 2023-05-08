package org.example;

public class Engine {
    private final double volume;
    private double mileage;
    private boolean isStarted;

    public Engine(double volume, double mileage) {
        this.volume = volume;
        this.mileage = mileage;
    }

    public void on() {
        isStarted = true;
    }

    public void off() {
        isStarted = false;
    }

    public void go(double mileage) {
        if(isStarted) {
            this.mileage += mileage;
        } else {
            throw new IllegalStateException("Cannot throttle when off, first switch on engine.");
        }
    }

    public double getVolume() {
        return volume;
    }

    public double getMileage() {
        return mileage;
    }

    public boolean isStarted() {
        return isStarted;
    }
}
