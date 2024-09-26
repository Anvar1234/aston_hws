package org.example.project.controller;

import org.example.project.presentation.AppMenu;
import org.example.project.service.AppService;

import java.io.IOException;
import java.util.*;

public class AppController {
    private final AppMenu appMenu;
    private final AppService appService;

    public AppController(AppMenu appMenu, AppService appService) {
        this.appMenu = appMenu;
        this.appService = appService;
    }

    public void run() {

        Map<Integer, List<?>> products = new HashMap<>();

        boolean exit = false;
        while (!exit) {
            int choice = appMenu.showMenu(AppMenu.MenuType.MAIN_MENU);

            switch (choice) {
                case 1 -> {
                    try {
                        products.clear();
                        choice = appMenu.showMenu(AppMenu.MenuType.DATA_INPUT_MENU);
                        products.put(0, appService.getHandleDataInput(choice));

                        System.out.println("Полученные данные: ");
                        for (int i = 0; i < products.get(0).size(); i++) {
                            System.out.println(products.get(0).get(i));
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e); //TODO: нормально обработать нужно.
                    }
                }
                case 2 -> {
                    if (!products.containsKey(0)) {
                        System.out.println("Сначала следует заполнить список.");

                    } else {
                        choice = appMenu.showMenu(AppMenu.MenuType.SORTING_MENU);
                        switch (choice) {
                            case 1 -> {
                                products.put(1, appService.getHandleSorting(products.get(0), choice));
                                products.get(1).forEach(System.out::println);
                            }
                            case 2 -> {
                                if (!products.containsKey(1)) {
                                    products.put(2, appService.getHandleSorting(products.get(0), choice));
                                } else {
                                    //TODO: проблема была здесь.
                                    List<?> temp = products.get(0); //Времянка для того, чтобы если пройдена сортировка слиянием, а потом по четным, а следом вызывается поиск, то поиск не происходил, так как список получится неотсортированным.
                                    products.put(2, appService.getHandleSorting(temp, choice));
                                    temp.forEach(System.out::println);
                                }
                            }
                            default -> System.out.println("Некорректный выбор. Повторите.");
                        }
                    }
                }

                case 3 -> {
                    if (!products.containsKey(0)) {
                        System.out.println("Сначала следует заполнить список.");
                    } else if (!products.containsKey(1)) {
                        System.out.println("Сначала следует отсортировать список через MergeSort.");
                    } else {
                        appService.getHandleBinarySearch(products.get(1));
                    }
                }

                case 4 -> exit = true;
                default -> System.out.println("Некорректный выбор. Повторите.");
            }
        }
    }
}
