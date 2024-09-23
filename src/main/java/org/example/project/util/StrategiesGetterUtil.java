package org.example.project.util;

import org.example.project.strategy.input.GeneralDataInput;
import org.example.project.strategy.input.impl.FileInputStrategy;
import org.example.project.strategy.input.impl.ManualInputStrategy;
import org.example.project.strategy.input.impl.RandomInputStrategy;
import org.example.project.strategy.parser.ProductParser;
import org.example.project.strategy.parser.impl.BookParser;
import org.example.project.strategy.parser.impl.CarParser;
import org.example.project.strategy.parser.impl.RootCporParser;
import org.example.project.strategy.prompt.Prompter;
import org.example.project.strategy.prompt.impl.BookPromptStrategy;
import org.example.project.strategy.prompt.impl.CarPromptStrategy;
import org.example.project.strategy.prompt.impl.RootCropPromptStrategy;
import org.example.project.strategy.random.RandomDataGenerator;
import org.example.project.strategy.random.impl.RandomBookStrategy;
import org.example.project.strategy.random.impl.RandomCarsStrategy;
import org.example.project.strategy.random.impl.RandomRootCropsStrategy;
import org.example.project.strategy.validation.DataValidator;
import org.example.project.strategy.validation.impl.BookValidationStrategy;
import org.example.project.strategy.validation.impl.CarValidationStrategy;
import org.example.project.strategy.validation.impl.RootCropValidationStrategy;

import java.util.HashMap;
import java.util.Map;

public class StrategiesGetterUtil {

    public StrategiesGetterUtil() {
        throw new UnsupportedOperationException("StrategiesGetterUtil - это утилитарный класс, " +
                "экземпляр не может быть создан!");
    }

    public static Map<Integer, DataValidator<?>> getValidatorStrategies() {
        Map<Integer, DataValidator<?>> validatorStrategies = new HashMap<>();
        validatorStrategies.put(1, new DataValidator<>(new CarValidationStrategy()));
        validatorStrategies.put(2, new DataValidator<>(new BookValidationStrategy()));
        validatorStrategies.put(3, new DataValidator<>(new RootCropValidationStrategy()));
        return validatorStrategies;
    }

    public static Map<Integer, RandomDataGenerator<?>> getRandomFillingStrategies() {
        Map<Integer, RandomDataGenerator<?>> randomFillingStrategies = new HashMap<>();
        randomFillingStrategies.put(1, new RandomDataGenerator<>(new RandomCarsStrategy()));
        randomFillingStrategies.put(2, new RandomDataGenerator<>(new RandomBookStrategy()));
        randomFillingStrategies.put(3, new RandomDataGenerator<>(new RandomRootCropsStrategy()));
        return randomFillingStrategies;
    }

    public static Map<Integer, Prompter> getPromptStrategies() {
        Map<Integer, Prompter> promptStrategies = new HashMap<>();
        promptStrategies.put(1, new Prompter(new CarPromptStrategy()));
        promptStrategies.put(2, new Prompter(new BookPromptStrategy()));
        promptStrategies.put(3, new Prompter(new RootCropPromptStrategy()));
        return promptStrategies;
    }

    public static Map<Integer, ProductParser<?>> getParserStrategies() {
        Map<Integer, ProductParser<?>> parserStrategies = new HashMap<>();
        parserStrategies.put(1, new ProductParser<>(new CarParser()));
        parserStrategies.put(2, new ProductParser<>(new BookParser()));
        parserStrategies.put(3, new ProductParser<>(new RootCporParser()));
        return parserStrategies;
    }

    public static Map<Integer, GeneralDataInput<?>> getInputStrategies() {
        Map<Integer, GeneralDataInput<?>> inputStrategies = new HashMap<>();
        inputStrategies.put(1, new GeneralDataInput<>(new FileInputStrategy<>()));
        inputStrategies.put(2, new GeneralDataInput<>(new ManualInputStrategy<>()));
        inputStrategies.put(3, new GeneralDataInput<>(new RandomInputStrategy<>()));
        return inputStrategies;
    }
}
