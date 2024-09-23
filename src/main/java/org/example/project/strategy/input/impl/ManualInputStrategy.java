package org.example.project.strategy.input.impl;

import org.example.project.strategy.input.InputStrategy;
import org.example.project.strategy.parser.ProductParser;
import org.example.project.strategy.prompt.Promter;
import org.example.project.strategy.validation.DataValidator;
import org.example.project.strategy.validation.Validationable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManualInputStrategy<T> implements InputStrategy<T> {
    private final DataValidator<T> dataValidator;
    private final ProductParser<T> parser;
    private final Promter promter;

    private final Scanner scanner = new Scanner(System.in);

    public ManualInputStrategy(DataValidator<T> dataValidator, ProductParser<T> parser, Promter promter) {
        this.dataValidator = dataValidator;
        this.parser = parser;
        this.promter = promter;
    }

    @Override
    public List<T> input(int count) throws IOException {
        List<T> dataList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            T car = inputObjectData();

            if (!dataValidator.isValid(car)) {
                throw new IllegalArgumentException("Некорректные данные для автомобиля."); //TODO: обрабатывать нормально, а не выводить.
            }
            dataList.add(car);
        }
        return dataList;
    }

    private T inputObjectData() throws IOException {
        String infoLine = promter.promptInfo();
        return parser.parseProduct(infoLine).get();
    }
}