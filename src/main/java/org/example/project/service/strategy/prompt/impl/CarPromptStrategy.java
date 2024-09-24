package org.example.project.service.strategy.prompt.impl;

import org.example.project.service.strategy.prompt.PromptStrategy;
import org.example.project.util.AppUtils;

public class CarPromptStrategy implements PromptStrategy {
    @Override
    public String prompt() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Car,");
        stringBuilder.append(AppUtils.prompt("Введите модель автомобиля:\n"));
        stringBuilder.append(",");
        stringBuilder.append(AppUtils.prompt("Введите мощность автомобиля:\n"));
        stringBuilder.append(",");
        stringBuilder.append(AppUtils.prompt("Введите год производства:\n"));
        return stringBuilder.toString();
    }
}
