package org.example.project.service;

import org.example.project.strategy.input.DataInputter;
import org.example.project.strategy.input.InputStrategy;
import org.example.project.strategy.input.FileNameSetable;
import org.example.project.strategy.input.ParseSetable;
import org.example.project.strategy.input.impl.FileInputStrategy;
import org.example.project.strategy.input.impl.ManualInputStrategy;
import org.example.project.strategy.input.impl.RandomInputStrategy;

import java.io.IOException;
import java.util.List;

import static org.example.project.util.AppUtils.*;
import static org.example.project.util.StrategiesGetterUtil.*;

/**
 * Утильный класс с методами для основной логики.
 */
public class AppService {
    private AppService() {
        throw new UnsupportedOperationException("AppService - это утилитарный класс, " +
                "экземпляр не может быть создан!");
    }

    public static void getHandleDataInput() throws IOException {

        int inputChoice = Integer.parseInt(promptWithOutMessage());

        List<?> products;
        DataInputter<?> strategy;

        switch (inputChoice) {
            case 1 -> { // TODO: добавить где-то проверку запрашиваемого типа, иначе можно спарсить из аутос.txt любой продукт. Возможно, на этапе парсинга.
                String fileName = prompt("Введите наименование файла: \n");

                System.out.println(PRODUCT_CHOISE_INTRO);
                int productId = Integer.parseInt(promptWithOutMessage());

                strategy = getInputStrategies(1); // Выбираем стратегию ввода из файла (id == 1).
                InputStrategy<?> inputStrategy = strategy.getInputStrategy(); // Получаем конкретную стратегию, чтобы засеттить данные.
                if (inputStrategy instanceof FileInputStrategy<?>) {
                    ((FileNameSetable) inputStrategy).setFileName(fileName);
                    ((ParseSetable) inputStrategy).setParseStrategy(getParseStrategies(productId));
                } else {
                    throw new UnsupportedOperationException("Что-то напутано в методе выбора стратегии ввода.");
                }

                int count = Integer.parseInt(prompt("Введите кол-во считываемых элементов: \n"));
                products = strategy.inputData(count);
            }
            case 2 -> {
                System.out.println(PRODUCT_CHOISE_INTRO);
                int productId2 = Integer.parseInt(promptWithOutMessage());

                strategy = getInputStrategies(2); // Выбираем стратегию ввода вручную (id == 2).
                InputStrategy<?> inputStrategy = strategy.getInputStrategy(); // Получаем конкретную стратегию, чтобы засеттить данные.

                if (inputStrategy instanceof ManualInputStrategy<?>) {
                    ((ManualInputStrategy<?>) inputStrategy).setParseStrategy(getParseStrategies(productId2));
                    ((ManualInputStrategy<?>) inputStrategy).setPromptStrategy(getPromptStrategies(productId2));
                } else {
                    throw new UnsupportedOperationException("Что-то напутано в методе выбора стратегии ввода.");
                }

                int count2 = Integer.parseInt(prompt("Введите кол-во вводимых элементов: \n"));
                products = strategy.inputData(count2);
            }
            case 3 -> {
                System.out.println(PRODUCT_CHOISE_INTRO);
                int productId3 = Integer.parseInt(promptWithOutMessage());

                strategy = getInputStrategies(3); // Выбираем стратегию ввода рандомом (id == 3).
                InputStrategy<?> inputStrategy = strategy.getInputStrategy();

                if(inputStrategy instanceof RandomInputStrategy<?>){
                    ((RandomInputStrategy<?>) inputStrategy).setRandomGeneratorStrategy(getRandomFillingStrategies(productId3));
                }

                int count3 = Integer.parseInt(prompt("Введите кол-во генерируемых элементов: \n"));
                products = strategy.inputData(count3);
            }
            default -> {
                System.out.println("Некорректный выбор.");
                return;
            }
        }

        System.out.println("Полученные данные: " + products + "\n");
    }

    public static void getHandleSorting() {

    }

    public static void getHandleBinarySearch() {

    }
}

