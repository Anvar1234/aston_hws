package org.example.project.service.comparator.impl;

import org.example.project.model.impl.Car;

import java.util.Comparator;

public class CarPowerComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getPower(), car2.getPower());
    }
}
