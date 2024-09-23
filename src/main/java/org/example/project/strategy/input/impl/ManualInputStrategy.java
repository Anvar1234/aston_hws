package org.example.project.strategy.input.impl;

import org.example.project.strategy.input.InputStrategy;
import org.example.project.strategy.parser.ProductParser;
import org.example.project.strategy.prompt.Prompter;
import org.example.project.strategy.validation.DataValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManualInputStrategy<T> implements InputStrategy<T> {
    private DataValidator<T> dataValidator;
    private ProductParser<T> parser;
    private Prompter prompter;

    public void setDataValidator(DataValidator<?> dataValidator) {
        this.dataValidator = (DataValidator<T>) dataValidator;
    }

    public void setParser(ProductParser<?> parser) {
        this.parser = (ProductParser<T>) parser;
    }

    public void setPrompter(Prompter prompter) {
        this.prompter = prompter;
    }

    @Override
    public List<T> input(int count) throws IOException {
        List<T> dataList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            T car = inputObjectData();

            if (!dataValidator.isValid(car)) {
                throw new IllegalArgumentException("Некорректные данные."); //TODO: обрабатывать нормально, а не выводить.
            }
            dataList.add(car);
        }
        return dataList;
    }

    private T inputObjectData() throws IOException {
        String infoLine = prompter.promptInfo();
        return parser.parseProduct(infoLine).get();
    }
}