package org.example.project.service.strategy.random.impl;

import org.example.project.model.Car;
import org.example.project.service.strategy.random.RandomFillingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCarsStrategy implements RandomFillingStrategy<Car> {
    @Override
    public List<Car> generateRandomData(int count) {
        Random random = new Random();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car.CarBuilder()
                    .setModel("Модель" + random.nextInt(1, 100))
                    .setPower((int) (Math.random() * 200 + 50))
                    .setYear((int) (Math.random() * 40 + 1980))
                    .build());
        }
        return cars;
    }
}
