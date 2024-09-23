package org.example.project.service;

import org.example.project.strategy.input.GeneralDataInput;
import org.example.project.strategy.input.impl.FileInputStrategy;
import org.example.project.strategy.input.impl.ManualInputStrategy;
import org.example.project.strategy.input.impl.RandomInputStrategy;
import org.example.project.util.AppUtils;
import org.example.project.util.StrategiesGetterUtil;

import java.io.IOException;
import java.util.List;

public class AppService {
    private AppService() {
        throw new UnsupportedOperationException("AppService - это утилитарный класс, " +
                "экземпляр не может быть создан!");
    }

    public static void getHandleDataInput() throws IOException {

        int inputChoice = Integer.parseInt(AppUtils.promptWithOutMessage());

        List<?> products;
        GeneralDataInput<?> strategy;

        switch (inputChoice) {
            case 1: // TODO: добавить где-то проверку запрашиваемого типа, иначе можно спарсить из аутос.txt любой продукт. Возможно, на этапе парсинга.
                String fileName = AppUtils.prompt("Введите наименование файла: \n");
                FileInputStrategy<?> fileInputStrategy = new FileInputStrategy<>();
                fileInputStrategy.setFileName(fileName);

                System.out.println(AppUtils.PRODUCT_CHOISE_INTRO);
                int productId = Integer.parseInt(AppUtils.promptWithOutMessage());
                fileInputStrategy.setParser(StrategiesGetterUtil.getParserStrategies().get(productId));

                int count = Integer.parseInt(AppUtils.prompt("Введите кол-во считываемых элементов: \n"));
                strategy = new GeneralDataInput<>(fileInputStrategy);
                products = strategy.inputData(count);
                break;
            case 2:
                System.out.println(AppUtils.PRODUCT_CHOISE_INTRO);
                int productId2 = Integer.parseInt(AppUtils.promptWithOutMessage());

                ManualInputStrategy<?> manualInputStrategy = new ManualInputStrategy<>();
                manualInputStrategy.setDataValidator(StrategiesGetterUtil.getValidatorStrategies().get(productId2));
                manualInputStrategy.setParser(StrategiesGetterUtil.getParserStrategies().get(productId2));
                manualInputStrategy.setPrompter(StrategiesGetterUtil.getPromptStrategies().get(productId2));

                strategy = new GeneralDataInput<>(manualInputStrategy);
                int count2 = Integer.parseInt(AppUtils.prompt("Введите кол-во записываемых элементов: \n"));
                products = strategy.inputData(count2);
                break;
            case 3:
                System.out.println(AppUtils.PRODUCT_CHOISE_INTRO);
                int productId3 = Integer.parseInt(AppUtils.promptWithOutMessage());

                RandomInputStrategy<?> randomInputStrategy = new RandomInputStrategy<>();
                randomInputStrategy.setGenerator(StrategiesGetterUtil.getRandomFillingStrategies().get(productId3));

                strategy = new GeneralDataInput<>(randomInputStrategy);
                int count3 = Integer.parseInt(AppUtils.prompt("Введите кол-во записываемых элементов: \n"));
                products = strategy.inputData(count3);
                break;
            default:
                System.out.println("Некорректный выбор.");
                return;
        }

        System.out.println("Полученные данные: " + products);
    }

    public static void getHandleSorting() {

    }

    public static void getHandleBinarySearch() {

    }
}

