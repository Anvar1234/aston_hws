package org.example.project.strategy.parser.impl;

import org.example.project.model.RootCrop;
import org.example.project.strategy.parser.ParseStrategy;

import java.io.IOException;
import java.util.Optional;

public class RootCporParseStrategy implements ParseStrategy<RootCrop> {
    @Override
    public Optional<RootCrop> parse(String line) throws IOException {
        RootCrop rootCrop = null;
        String[] parts = line.split(",");  // Предполагаем, что данные в файле разделены запятыми
        if (parts.length != 3) {
            throw new IOException("Ошибка в чтения строки!");
        }
        try {
            rootCrop = new RootCrop.RootCropBuilder()//TODO добавить проверки корректности ТИПА вводимых значений.
                    .setType(parts[0])
                    .setWeight(Integer.parseInt(parts[1]))
                    .setColor(parts[2])
                    .build();
        } catch (NumberFormatException e) {
            System.out.println(e); // TODO нормально везде обработать.
        }
        return Optional.ofNullable(rootCrop);
    }
}
