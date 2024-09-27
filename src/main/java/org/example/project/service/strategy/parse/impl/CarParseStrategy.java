package org.example.project.service.strategy.parse.impl;

import org.example.project.model.Car;
import org.example.project.service.strategy.parse.ParseStrategy;
import org.example.project.util.AppUtils;
import org.example.project.service.validation.impl.CarValidation;

import java.util.Optional;

public class CarParseStrategy implements ParseStrategy<Car> {
    @Override
    public Optional<Car> parse(String line) {
        try {
            Car car;
            String[] parts = line.split(",");
            if (parts.length != 4) {
                System.out.println("Ошибка: некорректное количество параметров в строке.");
                return Optional.empty();
            }
            if (!parts[0].toLowerCase().equalsIgnoreCase(Car.class.getSimpleName())) {
                System.out.println("Ошибка: выбранный тип продукта и тип из файла не совпадают!");
                return Optional.empty();
            }
            car = new Car.CarBuilder()
                    .setModel(parts[1])
                    .setPower(AppUtils.parseInteger(parts[2], "Мощность автомобиля должна быть числом."))
                    .setYear(AppUtils.parseInteger(parts[3], "Год выпуска должен быть числом."))
                    .build();
            if (!new CarValidation().validate(car)) {
                System.out.println("Ошибка: данные для полей не валидны.");
                return Optional.empty();
            }
            return Optional.of(car);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: тип данных после парсинга некорректен." + e.getMessage());
            return Optional.empty();
        }
    }
}