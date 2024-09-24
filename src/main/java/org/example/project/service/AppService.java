package org.example.project.service;

import org.example.project.presentation.AppMenu;
import org.example.project.strategy.input.DataInputter;
import org.example.project.strategy.input.InputStrategy;
import org.example.project.strategy.input.FileNameSetable;
import org.example.project.strategy.input.ParseSetable;
import org.example.project.strategy.input.impl.FileInputStrategy;
import org.example.project.strategy.input.impl.ManualInputStrategy;
import org.example.project.strategy.input.impl.RandomInputStrategy;
import org.example.project.util.AppUtils;

import java.io.IOException;
import java.util.List;

import static org.example.project.util.AppUtils.*;
import static org.example.project.util.StrategyGetterUtil.*;

/**
 * Утильный класс с методами для основной логики.
 */
public class AppService {

    private final AppMenu appMenu;

    public AppService(AppMenu appMenu) {
        this.appMenu = appMenu;
    }

    public void getHandleDataInput(int inputChoice) throws IOException {

        List<?> products;
        DataInputter<?> strategy;

        switch (inputChoice) {
            case 1 -> {
                strategy = getInputStrategies(1); // Выбираем стратегию ввода из файла (id == 1).
                InputStrategy<?> inputStrategy = strategy.getInputStrategy(); // Получаем конкретную стратегию, чтобы засеттить данные.
                String fileName = prompt("Введите наименование файла: \n");
                if (inputStrategy instanceof FileInputStrategy<?>) {
                    ((FileNameSetable) inputStrategy).setFileName(fileName);
                } else {
                    throw new UnsupportedOperationException("Что-то напутано в методе выбора стратегии ввода.");
                }

                int productId = appMenu.showMenu(AppMenu.MenuType.PRODUCT_CHOICE_MENU);
                ((ParseSetable) inputStrategy).setParseStrategy(getParseStrategies(productId));

                int count = AppUtils.parseInteger(prompt("Введите кол-во считываемых элементов: \n"), "Ввод должен быть числом");
                products = strategy.getInputData(count);
            }
            case 2 -> {
                strategy = getInputStrategies(2); // Выбираем стратегию ввода вручную (id == 2).
                InputStrategy<?> inputStrategy = strategy.getInputStrategy(); // Получаем конкретную стратегию, чтобы засеттить данные.
                int productId = appMenu.showMenu(AppMenu.MenuType.PRODUCT_CHOICE_MENU);

                if (inputStrategy instanceof ManualInputStrategy<?>) {
                    ((ManualInputStrategy<?>) inputStrategy).setParseStrategy(getParseStrategies(productId));
                    ((ManualInputStrategy<?>) inputStrategy).setPromptStrategy(getPromptStrategies(productId));
                } else {
                    throw new UnsupportedOperationException("Что-то напутано в методе выбора стратегии ввода.");
                }

                int count = AppUtils.parseInteger(prompt("Введите кол-во вводимых элементов: \n"), "Ввод должен быть числом");
                products = strategy.getInputData(count);
            }
            case 3 -> {
                strategy = getInputStrategies(3); // Выбираем стратегию ввода рандомом (id == 3).
                InputStrategy<?> inputStrategy = strategy.getInputStrategy(); // Получаем конкретную стратегию, чтобы засеттить данные.
                int productId = appMenu.showMenu(AppMenu.MenuType.PRODUCT_CHOICE_MENU);

                if (inputStrategy instanceof RandomInputStrategy<?>) {
                    ((RandomInputStrategy<?>) inputStrategy).setRandomGeneratorStrategy(getRandomFillingStrategies(productId));
                } else {
                    throw new UnsupportedOperationException("Что-то напутано в методе выбора стратегии ввода.");
                }

                int count = AppUtils.parseInteger(prompt("Введите кол-во генерируемых элементов: \n"), "Ввод должен быть числом");
                products = strategy.getInputData(count);
            }
            default -> {
                System.out.println("Некорректный выбор.");
                return;
            }
        }
        System.out.println("Полученные данные: " + products + "\n"); //TODO: потом удалить вывод.
    }

    public static void getHandleSorting() {

    }

    public static void getHandleBinarySearch() {

    }
}

