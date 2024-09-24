package org.example.project.service.strategy.input.impl;

import org.example.project.service.strategy.input.ParseSetable;
import org.example.project.service.strategy.input.PromptSetable;
import org.example.project.service.strategy.input.InputStrategy;
import org.example.project.service.strategy.parser.ProductParser;
import org.example.project.service.strategy.prompt.ProductPrompter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManualInputStrategy<T> implements InputStrategy<T>, ParseSetable, PromptSetable {
    private ProductParser<T> parser;
    private ProductPrompter promptStrategy;

    @Override
    public void setPromptStrategy(ProductPrompter promptStrategy) {
        this.promptStrategy = promptStrategy;
    }

    @Override
    public void setParseStrategy(ProductParser<?> parser) {
        this.parser = (ProductParser<T>) parser;
    }

    @Override
    public List<T> input(int count) throws IOException {
        List<T> dataList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            T car = inputObjectData();
            dataList.add(car);
        }
        return dataList;
    }

    private T inputObjectData() throws IOException {
        String infoLine = promptStrategy.promptInfo();
        return parser.parseProduct(infoLine).get();
    }
}