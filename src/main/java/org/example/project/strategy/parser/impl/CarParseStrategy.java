package org.example.project.strategy.parser.impl;

import org.example.project.model.Car;
import org.example.project.strategy.parser.ParseStrategy;

import java.io.IOException;
import java.util.Optional;

public class CarParseStrategy implements ParseStrategy<Car> {
    @Override
    public Optional<Car> parse(String line) throws IOException {
        Car car = null;
        String[] parts = line.split(",");  // Предполагаем, что данные в файле разделены запятыми
        if (parts.length != 3) {
            throw new IOException("Ошибка в чтения строки!");
        }
        try {
            car = new Car.CarBuilder() //TODO добавить проверки корректности ТИПА вводимых значений.
                    .setModel(parts[0])
                    .setPower(Integer.parseInt(parts[1]))
                    .setYear(Integer.parseInt(parts[2]))
                    .build();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage()); // TODO нормально везде обработать.
        }
        return Optional.ofNullable(car);
    }
}
