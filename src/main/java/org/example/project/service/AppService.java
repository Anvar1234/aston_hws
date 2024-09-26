package org.example.project.service;

import org.example.project.model.ComparatorGetable;
import org.example.project.model.NumericFieldGetable;
import org.example.project.model.impl.Book;
import org.example.project.model.impl.Car;
import org.example.project.model.impl.RootCrop;
import org.example.project.presentation.AppMenu;
import org.example.project.service.comparator.UniversalComparator;
import org.example.project.service.comparator.impl.CarPowerComparator;
import org.example.project.service.sort.impl.EvenNumberMergeSort;
import org.example.project.service.sort.impl.MergeSort;
import org.example.project.service.strategy.input.DataInputter;
import org.example.project.service.strategy.input.InputStrategy;
import org.example.project.service.strategy.input.FileNameSetable;
import org.example.project.service.strategy.input.ParseSetable;
import org.example.project.service.strategy.input.impl.FileInputStrategy;
import org.example.project.service.strategy.input.impl.ManualInputStrategy;
import org.example.project.service.strategy.input.impl.RandomInputStrategy;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import static org.example.project.util.AppUtils.*;
import static org.example.project.util.StrategyGetterUtil.*;

public class AppService {

    private final AppMenu appMenu;

    public AppService(AppMenu appMenu) {
        this.appMenu = appMenu;
    }

    public List<?> getHandleDataInput(int inputChoice) throws IOException {

        List<?> products = List.of();
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

                int productId = appMenu.showMenu(AppMenu.MenuType.PRODUCT_CHOICE_MENU); // TODO: добавить прверки, если число <=0 и если больше кол-ва пунктов меню. Добавить енамам метод getMenuLength
                ((ParseSetable) inputStrategy).setParseStrategy(getParseStrategies(productId));

                int count = parseInteger(prompt("Введите кол-во считываемых элементов: \n"), "Ввод должен быть числом");
                products = strategy.getInputData(count);
                for (int i = 0; i < products.size(); i++) { //TODO: почистить
                    System.out.println(products.get(i));
                }
                return products;
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

                int count = parseInteger(prompt("Введите кол-во вводимых элементов: \n"), "Ввод должен быть числом");
                products = strategy.getInputData(count);
                return products;
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

                int count = parseInteger(prompt("Введите кол-во генерируемых элементов: \n"), "Ввод должен быть числом");
                products = strategy.getInputData(count);
                return products;
            }
            default -> {
                System.out.println("Некорректный выбор.");
            }

        }
//        System.out.println("Полученные данные: " + products + "\n"); //TODO: потом удалить , это не работает.
        return products;
    }

    public List<?> getHandleSorting(List<?> products, int choice) {
        switch (choice) {
            case 1 -> {
                    new MergeSort<>().mergeSort((List) products);
                    return products;
                }

            case 2 -> { //вот комент
                if (products.get(0) instanceof Car) {
                    new EvenNumberMergeSort<>().evenMergeSort((List) products, new UniversalComparator<Car>("power"));
                    return products;
                } else if (products.get(0) instanceof Book) {
                    new EvenNumberMergeSort<>().evenMergeSort((List) products, new UniversalComparator<Book>("pages"));
                    return products;
                } else if (products.get(0) instanceof RootCrop) {
                    new EvenNumberMergeSort<>().evenMergeSort((List) products, new UniversalComparator<RootCrop>("weight"));
                    return products;
                } else {
                    System.out.println("Список заполнен чем-то не тем.");
                }
//                new EvenNumberMergeSort<>().evenMergeSort((List<NumericFieldGetable<Number>>) products.get(0), ((ComparatorGetable) ((List) products.get(0)).get(0)).getComparator());
//                return products;
            }
            default -> System.out.println("Некорректный выбор.");
        }
        return List.of();
    }

    public void getHandleBinarySearch() {
        System.out.println("Хер тебе, а не поиск.");
    }
}

