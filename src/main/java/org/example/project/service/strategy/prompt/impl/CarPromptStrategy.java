package org.example.project.service.strategy.prompt.impl;

import org.example.project.service.strategy.prompt.PromptStrategy;
import org.example.project.util.AppUtils;

public class CarPromptStrategy implements PromptStrategy {
    @Override
    public String prompt() {
        return "Car," +
                AppUtils.prompt("Введите модель автомобиля:\n") +
                "," +
                AppUtils.prompt("Введите мощность автомобиля:\n") +
                "," +
                AppUtils.prompt("Введите год производства:\n");
    }
}
