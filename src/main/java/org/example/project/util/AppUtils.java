package org.example.project.util;

import java.util.Scanner;

public class AppUtils {
    public static final String PRODUCT_CHOISE_INTRO =
            """
                    Выберите продукт:
                    1. Автомобиль
                    2. Книга
                    3. Корнеплод (чтоб его за ногу)
                    """.stripTrailing();

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
}
