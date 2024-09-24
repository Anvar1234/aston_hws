package org.example.project.strategy.parser.impl;

import org.example.project.model.RootCrop;
import org.example.project.strategy.parser.ParseStrategy;
import org.example.project.util.AppUtils;
import org.example.project.validation.impl.RootCropValidation;

import java.io.IOException;
import java.util.Optional;

public class RootCporParseStrategy implements ParseStrategy<RootCrop> {
    @Override
    public Optional<RootCrop> parse(String line) {
        RootCrop rootCrop;
        String[] parts = line.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Некорректное количество параметров в строке.");
        }
        if(!parts[0].toLowerCase().equalsIgnoreCase(RootCrop.class.getSimpleName())){
            throw new IllegalArgumentException("Выбранный тип продукта и тип из файла не совпадают!");
        }
        try {
            rootCrop = new RootCrop.RootCropBuilder()//TODO добавить проверки корректности ТИПА вводимых значений.
                    .setType(parts[1])
                    .setWeight(AppUtils.parseDouble(parts[2], "Вес корнеплода должен быть числом.")) // TODO: здесь дабл, не интежер!
                    .setColor(parts[3])
                    .build();
            if (!new RootCropValidation().validate(rootCrop)) {
                throw new IllegalArgumentException("Данные для полей не валидны.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Тип данных после парсинга некорректен." + e.getMessage());
        }
        return Optional.of(rootCrop);
    }
}
