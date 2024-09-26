package org.example.project.service;

import org.example.project.model.impl.Book;
import org.example.project.model.impl.Car;
import org.example.project.model.impl.RootCrop;
import org.example.project.presentation.AppMenu;
import org.example.project.service.comparator.impl.BookPagesComparator;
import org.example.project.service.comparator.impl.CarPowerComparator;
import org.example.project.service.comparator.impl.RootCropWeightComparator;
import org.example.project.service.search.impl.BookSerachStrategy;
import org.example.project.service.search.impl.CarSearchStrategy;
import org.example.project.service.search.impl.RootCropSearchStrategy;
import org.example.project.service.sort.EvenNumberMergeSort;
import org.example.project.service.sort.MergeSort;
import org.example.project.service.strategy.input.DataInputter;
import org.example.project.service.strategy.input.InputStrategy;
import org.example.project.service.strategy.input.FileNameSetable;
import org.example.project.service.strategy.input.ParseSetable;
import org.example.project.service.strategy.input.impl.FileInputStrategy;
import org.example.project.service.strategy.input.impl.ManualInputStrategy;
import org.example.project.service.strategy.input.impl.RandomInputStrategy;
import org.example.project.util.AppUtils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
                products = strategy.input(count);
                for (int i = 0; i < products.size(); i++) { //TODO: почистить или оставить
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
                products = strategy.input(count);
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
                products = strategy.input(count);
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

            case 2 -> {
                if (products.get(0) instanceof Car) {
                    new EvenNumberMergeSort<>().evenMergeSort((List) products, new CarPowerComparator());
                    return products;
                } else if (products.get(0) instanceof Book) {
                    new EvenNumberMergeSort<>().evenMergeSort((List) products, new BookPagesComparator());
                    return products;
                } else if (products.get(0) instanceof RootCrop) {
                    new EvenNumberMergeSort<>().evenMergeSort((List) products, new RootCropWeightComparator());
                    return products;
                } else {
                    System.out.println("Список заполнен чем-то не тем."); //TODO: если сначала пройти все 3 этапа и через мерге сорт, а потом снова выбрать сортировку, но уже по четным, тогда выходит это сообщение. Это потому, что я создаю копию для четной сортировки.
                }
            }
            default -> System.out.println("Некорректный выбор.");
        }
        return List.of();
    }

    public void getHandleBinarySearch(List<?> products) {
        if (products.get(0) instanceof Car) {
            String target = AppUtils.prompt("Введите наименование модели: ");
            Optional<Car> car = new CarSearchStrategy().binarySearch((List<Car>) products, target);
            if (car.isPresent()) {
                System.out.println(car.get());
            } else System.out.println("Ничего не найдено :(");
        } else if (products.get(0) instanceof Book) {
            String target = AppUtils.prompt("Введите название книги: ");
            Optional<Book> book = new BookSerachStrategy().binarySearch((List<Book>) products, target);
            if (book.isPresent()) {
                System.out.println(book.get());
            } else System.out.println("Ничего не найдено :(");
        } else if (products.get(0) instanceof RootCrop) {
            String target = AppUtils.prompt("Введите тип корнеплода: ");
            Optional<RootCrop> rootCrop = new RootCropSearchStrategy().binarySearch((List<RootCrop>) products, target);
            if (rootCrop.isPresent()) {
                System.out.println(rootCrop.get());
            } else System.out.println("Ничего не найдено :(");
        } else {
            System.out.println("Список заполнен чем-то не тем.");
        }
    }
}

