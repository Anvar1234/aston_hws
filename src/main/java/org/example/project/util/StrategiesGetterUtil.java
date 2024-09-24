package org.example.project.util;

import org.example.project.strategy.input.DataInputter;
import org.example.project.strategy.input.impl.FileInputStrategy;
import org.example.project.strategy.input.impl.ManualInputStrategy;
import org.example.project.strategy.input.impl.RandomInputStrategy;
import org.example.project.strategy.parser.ProductParser;
import org.example.project.strategy.parser.impl.BookParseStrategy;
import org.example.project.strategy.parser.impl.CarParseStrategy;
import org.example.project.strategy.parser.impl.RootCporParseStrategy;
import org.example.project.strategy.prompt.ProductPrompter;
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

    private StrategiesGetterUtil() {
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

    /**
     * Открытый статический метод получения стратегии рандома по id.<br>
     * 1 - рандом для Авто.<br>
     * 2 - рандом для Книги.<br>
     * 3 - рандом для Корнеплода (чтоб его за ногу).
     * @param id - идентификатор стратегии.
     * @return RandomDataGenerator - возвращает общий для стратегий тип RandomDataGenerator, имеющий метод получения списка рандомных объектов в зависимости от продукта.
     */
    public static RandomDataGenerator<?> getRandomFillingStrategies(int id) {
        Map<Integer, RandomDataGenerator<?>> randomFillingStrategies = new HashMap<>();
        randomFillingStrategies.put(1, new RandomDataGenerator<>(new RandomCarsStrategy()));
        randomFillingStrategies.put(2, new RandomDataGenerator<>(new RandomBookStrategy()));
        randomFillingStrategies.put(3, new RandomDataGenerator<>(new RandomRootCropsStrategy()));
        return randomFillingStrategies.get(id);
    }

    /**
     * Открытый статический метод получения стратегии промпта по id.<br>
     * 1 - промпт для Авто.<br>
     * 2 - промпт для Книги.<br>
     * 3 - промпт для Корнеплода (чтоб его за ногу).
     * @param id - идентификатор стратегии.
     * @return ProductPrompter - возвращает общий для стратегий тип ProductPrompter, имеющий метод промпта в зависимости от продукта.
     */
    public static ProductPrompter getPromptStrategies(int id) {
        Map<Integer, ProductPrompter> promptStrategies = new HashMap<>();
        promptStrategies.put(1, new ProductPrompter(new CarPromptStrategy()));
        promptStrategies.put(2, new ProductPrompter(new BookPromptStrategy()));
        promptStrategies.put(3, new ProductPrompter(new RootCropPromptStrategy()));
        return promptStrategies.get(id);
    }

    /**
     * Открытый статический метод получения стратегии парсинга по id.<br>
     * 1 - парсинг Авто.<br>
     * 2 - парсинг Книги.<br>
     * 3 - парсинг Корнеплода (чтоб его за ногу).
     * @param id - идентификатор стратегии.
     * @return ProductParser - возвращает общий для стратегий тип ProductParser, имеющий метод парсинга в зависимости от продукта.
     */
    public static ProductParser<?> getParseStrategies(int id) {
        Map<Integer, ProductParser<?>> parserStrategies = new HashMap<>();
        parserStrategies.put(1, new ProductParser<>(new CarParseStrategy()));
        parserStrategies.put(2, new ProductParser<>(new BookParseStrategy()));
        parserStrategies.put(3, new ProductParser<>(new RootCporParseStrategy()));
        return parserStrategies.get(id);
    }

    /**
     * Открытый статический метод получения стратегии ввода по id.<br>
     * 1 - ввод из файла.<br>
     * 2 - ввод вручную.<br>
     * 3 - ввод рандом.
     * @param id - идентификатор стратегии.
     * @return DataInputter - возвращает общий для стратегий тип DataInputter, с полем стратегии ввода.
     */
    public static DataInputter<?> getInputStrategies(int id) {
        Map<Integer, DataInputter<?>> inputStrategies = new HashMap<>();
        inputStrategies.put(1, new DataInputter<>(new FileInputStrategy<>()));
        inputStrategies.put(2, new DataInputter<>(new ManualInputStrategy<>()));
        inputStrategies.put(3, new DataInputter<>(new RandomInputStrategy<>()));
        return inputStrategies.get(id);
    }
}
