package org.example.project.service.strategy.parse.impl;

import org.example.project.model.impl.RootCrop;
import org.example.project.service.strategy.parse.ParseStrategy;
import org.example.project.util.AppUtils;
import org.example.project.service.validation.impl.RootCropValidation;

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
                    .setWeight(AppUtils.parseInteger(parts[2], "Вес корнеплода должен быть числом.")) // TODO: здесь дабл, не интежер!
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
