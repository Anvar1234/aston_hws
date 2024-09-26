package org.example.project.model.impl;

import org.example.project.model.ComparatorGetable;
import org.example.project.model.FieldsNamesGetable;
import org.example.project.model.NumericFieldGetable;
import org.example.project.service.comparator.UniversalComparator;

import java.util.Comparator;
import java.util.List;

public class Car implements Comparable<Car>, FieldsNamesGetable, NumericFieldGetable<Integer>, ComparatorGetable<Car> { //TODO: удалить ненужные импл.
    private final String model;
    private final int power;
    private final int year;

    private Car(CarBuilder builder) {
        this.model = builder.model;
        this.power = builder.power;
        this.year = builder.year;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Car other) {
        return this.model.compareTo(other.model); // Сортировка по модели по умолчанию
    }

    @Override
    public String toString() {
        return "Авто: модель= " + model + ", мощность= " + power + ", дата выпуска= " + year;
    }

    @Override
    public List<String> getFieldsNames() {
        return List.of("model", "power", "year");
    }

    @Override
    public Integer getNumericField() {
        return getPower();
    }

    @Override
    public Comparator<Car> getComparator() {
        return new UniversalComparator<>("power");
    }

    // Внутренний класс билдер
    public static class CarBuilder {
        private String model;
        private int power;
        private int year;

        public CarBuilder setModel(String model) { //TODO добавить проверку корректности ТИПОВ во все сеттеры. И также добавить проверку в сканнере.
            this.model = model;
            return this;
        }

        public CarBuilder setPower(int power) {
            this.power = power;
            return this;
        }

        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}