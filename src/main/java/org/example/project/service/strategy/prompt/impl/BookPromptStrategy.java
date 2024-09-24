package org.example.project.service.strategy.prompt.impl;

import org.example.project.service.strategy.prompt.PromptStrategy;
import org.example.project.util.AppUtils;

public class BookPromptStrategy implements PromptStrategy {

    @Override
    public String prompt() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Book,");
        stringBuilder.append(AppUtils.prompt("Введите автора книги:\n"));
        stringBuilder.append(",");
        stringBuilder.append(AppUtils.prompt("Введите название книги:\n"));
        stringBuilder.append(",");
        stringBuilder.append(AppUtils.prompt("Введите количество страниц:\n"));
        return stringBuilder.toString();
    }
}
