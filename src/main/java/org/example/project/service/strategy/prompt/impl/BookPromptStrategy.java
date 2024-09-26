package org.example.project.service.strategy.prompt.impl;

import org.example.project.service.strategy.prompt.PromptStrategy;
import org.example.project.util.AppUtils;

public class BookPromptStrategy implements PromptStrategy {

    @Override
    public String prompt() {
        return "Book," +
                AppUtils.prompt("Введите автора книги:\n") +
                "," +
                AppUtils.prompt("Введите название книги:\n") +
                "," +
                AppUtils.prompt("Введите количество страниц:\n");
    }
}