package org.example.project.strategy.prompt.impl;

import org.example.project.strategy.prompt.Promptable;
import org.example.project.util.AppUtils;

public class BookPromptStrategy implements Promptable {

    @Override
    public String prompt() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppUtils.prompt("Введите автора книги:\n"));
        stringBuilder.append(",");
        stringBuilder.append(AppUtils.prompt("Введите название книги:\n"));
        stringBuilder.append(",");
        stringBuilder.append(AppUtils.prompt("Введите количество страниц:\n"));
        return stringBuilder.toString();
    }
}
