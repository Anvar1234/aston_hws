package org.example.project.util;

import java.util.Scanner;

public class AppUtils {
    public static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
