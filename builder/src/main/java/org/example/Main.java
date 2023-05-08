package org.example;

import org.example.builders.AutomaticCarBuilder;
import org.example.builders.Builder;
import org.example.cars.Car;

public class Main {
    public static void main(String[] args) {
        Builder automaticBuilder = new AutomaticCarBuilder();
        Director director = new Director();
        director.constructSportsCar(automaticBuilder);
        Car car = automaticBuilder.getCar();
    }
}