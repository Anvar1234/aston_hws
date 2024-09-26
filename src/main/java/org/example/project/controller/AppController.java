package org.example.project.controller;

import org.example.project.model.ComparatorGetable;
import org.example.project.model.NumericFieldGetable;
import org.example.project.presentation.AppMenu;
import org.example.project.service.AppService;
import org.example.project.service.sort.impl.EvenNumberMergeSort;
import org.example.project.service.sort.impl.MergeSort;
import org.example.project.util.AppUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                        choice = appMenu.showMenu(AppMenu.MenuType.DATA_INPUT_MENU);
                        products.put(0, appService.getHandleDataInput(choice));

                        System.out.println("Полученные данные: ");
                        for (int i = 0; i < products.get(0).size(); i++) {//TODO: удалить.
                            System.out.println(products.get(0).get(i));
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e); //TODO: нормально обработать нужно.
                    }
                }
                case 2 -> {
                    if (!products.containsKey(0)) {
                        System.out.println("Сначала следует заполнить список.");
                        return;
                    } else {
                        choice = appMenu.showMenu(AppMenu.MenuType.SORTING_MENU);
                        switch (choice) {
//TODO: сделать типа того. То есть получать компаратор у продукта и все.
//                        products.put(1, appService.getHandleSorting((Map<Integer, List<?>>) products.get(0), products.get(0).getComparator, getStrategy)); // TODO: вот это не забыть. И если так написать, то сможет ли получить свое значение по ключу? А, должно.
                            case 1 -> {//мерге сорт
                                System.out.println("В касе 1");
                                //TODO: проверка, что не пустой список в мапе.
                                products.put(1, appService.getHandleSorting(products.get(0), choice));
                                products.get(1).forEach(System.out::println);
                            }
                            case 2 -> { //мерге сорт по четным
                                System.out.println("В касе 2");
//                                new EvenNumberMergeSort<>().evenMergeSort((List<NumericFieldGetable<Number>>) products.get(0), ((ComparatorGetable) products.get(0).get(0)).getComparator());
                                products.put(2, appService.getHandleSorting(products.get(0), choice));
                                products.get(2).forEach(System.out::println);

//                                System.out.println("В касе 2");
//                                new EvenNumberMergeSort<>().evenMergeSort((List<NumericFieldGetable<Number>>) products.get(0), ((ComparatorGetable) products.get(0).get(0)).getComparator());
//                                products.put(2, products.get(0));
//                                products.get(2).forEach(System.out::println);
                            }
                        }
                    }
                }

                case 3 -> {
                    if (!products.containsKey(1)) {
                        System.out.println("Сначала следует отсортировать список через MergeSort.");
                        return;
                    } else {
                        appService.getHandleBinarySearch();
                    }
                }

                case 4 -> exit = true;
                default -> System.out.println("Некорректный выбор. Повторите.");
            }
        }
    }
}
