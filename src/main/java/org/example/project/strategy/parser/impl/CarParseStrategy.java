package org.example.project.strategy.parser.impl;

import org.example.project.model.Car;
import org.example.project.strategy.parser.ParseStrategy;
import org.example.project.util.AppUtils;
import org.example.project.validation.impl.CarValidation;

import java.io.IOException;
import java.util.Optional;

public class CarParseStrategy implements ParseStrategy<Car> {
    @Override
    public Optional<Car> parse(String line) {
        Car car;
        String[] parts = line.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Некорректное количество параметров в строке.");
        }
        if (!parts[0].toLowerCase().equalsIgnoreCase(Car.class.getSimpleName())) {
            throw new IllegalArgumentException("Выбранный тип продукта и тип из файла не совпадают!");
        }
        try {
            car = new Car.CarBuilder()
                    .setModel(parts[1])
                    .setPower(AppUtils.parseInteger(parts[2], "Мощность автомобиля должна быть числом."))
                    .setYear(AppUtils.parseInteger(parts[3], "Год выпуска должен быть числом."))
                    .build();
            if (!new CarValidation().validate(car)) {
                throw new IllegalArgumentException("Данные для полей не валидны.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Тип данных после парсинга некорректен." + e.getMessage());
        }
        return Optional.of(car);
    }
}
