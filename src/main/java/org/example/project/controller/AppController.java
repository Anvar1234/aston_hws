package org.example.project.controller;

import org.example.project.service.AppService;
import org.example.project.util.AppUtils;

import java.io.IOException;

public class AppController {

    private AppController() {
        throw new UnsupportedOperationException("AppController - это утилитарный класс, " +
                "экземпляр не может быть создан!");
    }

    public static void run() {

        boolean exit = false;
        while (!exit) {
            System.out.println("Выберите действие:");
            System.out.println("1. Выбор метода ввода данных");
            System.out.println("2. Выбор алгоритма сортировки");
            System.out.println("3. Выполнить бинарный поиск");
            System.out.println("4. Выйти");
            int choice = Integer.parseInt(AppUtils.prompt(""));

            switch (choice) {
                case 1:
                    try {
                        System.out.println("Выберите способ ввода данных:");
                        System.out.println("1. Из файла");
                        System.out.println("2. Вручную");
                        System.out.println("3. Случайным образом");
                        AppService.getHandleDataInput();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
//                   AppService.getHandleSorting();
                    break;
                case 3:
//                    AppService.getHandleBinarySearch();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный выбор. Повторите.");
            }
        }
    }
}
