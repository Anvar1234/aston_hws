package org.example.project.util;

import org.example.project.presentation.AppMenu;

import java.util.Scanner;

public class AppUtils {

    private AppUtils() {
        throw new UnsupportedOperationException("AppUtils - это утилитарный класс, " +
                "экземпляр не может быть создан!");
    }

    public static String promptWithOutMessage() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    public static int parseInteger(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage, e);
        }
    }

    public static int getValidPrompt(int leftBound, int rightBound, AppMenu appMenu, AppMenu.MenuType menuType){
        int dataInputChoice = appMenu.showMenu(menuType);
        while (dataInputChoice < leftBound || dataInputChoice > rightBound) {
            System.out.println("\nНекорректный выбор. Повторите.");
            dataInputChoice = appMenu.showMenu(menuType);
        }
        return dataInputChoice;
    }
}
