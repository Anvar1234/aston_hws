package org.example.project;

import org.example.project.controller.AppController;
import org.example.project.model.Book;
import org.example.project.strategy.input.GeneralDataInput;
import org.example.project.strategy.input.impl.FileInputStrategy;
import org.example.project.strategy.input.impl.ManualInputStrategy;
import org.example.project.strategy.input.impl.RandomInputStrategy;
import org.example.project.strategy.parser.ProductParser;
import org.example.project.strategy.parser.impl.BookParser;
import org.example.project.strategy.prompt.Prompter;
import org.example.project.strategy.prompt.impl.BookPromptStrategy;
import org.example.project.strategy.validation.DataValidator;
import org.example.project.strategy.validation.impl.BookValidationStrategy;
import org.example.project.util.AppUtils;
import org.example.project.util.StrategiesGetterUtil;

import java.io.IOException;
import java.util.List;

public class AppRunner {
    public static void main(String[] args) throws IOException {
        //Это старый код, еще до параметризации интерфейсов и классов (используются сырые типы и явное приведение типов):
//        DataValidator carValidation = new DataValidator(new CarValidationStrategy());
//        RandomDataGenerator generator = new RandomDataGenerator(new RandomCarsStrategy());
//        List<Car> cars = (List<Car>) generator.getRandomData(4);
//        System.out.println(cars);
//        for (Car car : cars) {
//            System.out.println(carValidation.isValid(car));
//        }
//
//        DataValidator bookValidation = new DataValidator(new BookValidationStrategy());
//        generator = new RandomDataGenerator(new RandomBookStrategy());
//        List<Book> books = (List<Book>) generator.getRandomData(5);
//        System.out.println(books);
//        for (Book book : books) {
//            System.out.println(bookValidation.isValid(book));
//        }
//
//        DataValidator rootCropValidation = new DataValidator(new RootCropValidationStrategy());
//        generator = new RandomDataGenerator(new RandomRootCropsStrategy());
//        List<RootCrop> rootCrops = (List<RootCrop>) generator.getRandomData(2);
//        System.out.println(rootCrops);
//        for (RootCrop rootCrop : rootCrops) {
//            System.out.println(rootCropValidation.isValid(rootCrop));
//        }

        //Парсинг из файла:
//        ProductParser<Car> parser = new ProductParser<>(new CarParser());
//        DataValidator<Car> carDataValidator = new DataValidator<>(new CarValidationStrategy());
//        GeneralDataInput<Car> dataInput = new GeneralDataInput<>(new FileInputStrategy<>();
//        List<Car> cars2;
//        try {
//            cars2 = dataInput.inputData(2);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(cars2);

        //Ручной ввод:
//        DataValidator<Book> bookValidator = new DataValidator<>(new BookValidationStrategy());
//        ProductParser<Book> bookParser = new ProductParser<>(new BookParser());
//        Prompter promter = new Prompter(new BookPromptStrategy());
//        ManualInputStrategy<Book> bookManualInputStrategy = new ManualInputStrategy<>();
//        bookManualInputStrategy.setDataValidator(bookValidator);
//        bookManualInputStrategy.setParser(bookParser);
//        bookManualInputStrategy.setPrompter(promter);
//        GeneralDataInput<Book> bookInput = new GeneralDataInput<>(bookManualInputStrategy);
//
//        List<Book> books2;
//        try {
//            books2 = bookInput.inputData(2);
//        } catch (IOException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//        System.out.println(books2);

        //Рандомный ввод:
//        RandomInputStrategy<RootCrop> randomInputStrategy = new RandomInputStrategy<>(new RandomDataGenerator<>(new RandomRootCropsStrategy()));
//        List<RootCrop> rootCrops2 = randomInputStrategy.input(4);
//        System.out.println(rootCrops2);


//        boolean exit = false;
//        while (!exit) {
//            System.out.println("Выберите действие:");
//            System.out.println("1. Выбор метода ввода данных");
//            System.out.println("2. Выбор алгоритма сортировки");
//            System.out.println("3. Выполнить бинарный поиск");
//            System.out.println("4. Выйти");
//            int choice = Integer.parseInt(AppUtils.prompt(""));
//
//            switch (choice) {
//                case 1:
//                    handleDataInput();
//                    break;
//                case 2:
////                    handleSorting();
//                    break;
//                case 3:
////                    handleBinarySearch();
//                    break;
//                case 4:
//                    exit = true;
//                    break;
//                default:
//                    System.out.println("Некорректный выбор. Повторите.");
//            }
//        }
//
//    }
//
//    private static void handleDataInput() throws IOException {
//        System.out.println("Выберите способ ввода данных:");
//        System.out.println("1. Из файла");
//        System.out.println("2. Вручную");
//        System.out.println("3. Случайным образом \n");
//        int inputChoice = Integer.parseInt(AppUtils.promptWithOutMessage());
//
//        List<?> products;
//        GeneralDataInput<?> strategy;
//
//        switch (inputChoice) {
//            case 1:
//                String fileName = AppUtils.prompt("Введите наименование файла: \n");
//                FileInputStrategy<?> fileInputStrategy = new FileInputStrategy<>();
//                fileInputStrategy.setFileName(fileName);
//
//                System.out.println(AppUtils.PRODUCT_CHOISE_INTRO);
//                int productId = Integer.parseInt(AppUtils.promptWithOutMessage());
//                fileInputStrategy.setParser(StrategiesGetterUtil.getParserStrategies().get(productId));
//
//                int count = Integer.parseInt(AppUtils.prompt("Введите кол-во считываемых элементов: \n"));
//                strategy = new GeneralDataInput<>(fileInputStrategy);
//                products = strategy.inputData(count);
//                break;
//            case 2:
//                System.out.println(AppUtils.PRODUCT_CHOISE_INTRO);
//                int productId2 = Integer.parseInt(AppUtils.promptWithOutMessage());
//
//                ManualInputStrategy<?> manualInputStrategy = new ManualInputStrategy<>();
//                manualInputStrategy.setDataValidator(StrategiesGetterUtil.getValidatorStrategies().get(productId2));
//                manualInputStrategy.setParser(StrategiesGetterUtil.getParserStrategies().get(productId2));
//                manualInputStrategy.setPrompter(StrategiesGetterUtil.getPromptStrategies().get(productId2));
//
//                strategy = new GeneralDataInput<>(manualInputStrategy);
//                int count2 = Integer.parseInt(AppUtils.prompt("Введите кол-во записываемых элементов: \n"));
//                products = strategy.inputData(count2);
//                break;
//            case 3:
//                System.out.println(AppUtils.PRODUCT_CHOISE_INTRO);
//                int productId3 = Integer.parseInt(AppUtils.promptWithOutMessage());
//
//                RandomInputStrategy<?> randomInputStrategy = new RandomInputStrategy<>();
//                randomInputStrategy.setGenerator(StrategiesGetterUtil.getRandomFillingStrategies().get(productId3));
//
//                strategy = new GeneralDataInput<>(randomInputStrategy);
//                int count3 = Integer.parseInt(AppUtils.prompt("Введите кол-во записываемых элементов: \n"));
//                products = strategy.inputData(count3);
//                break;
//            default:
//                System.out.println("Некорректный выбор.");
//                return;
//        }
//
//        System.out.println("Полученные данные: " + products);
//    }
        AppController.run();
    }
}

