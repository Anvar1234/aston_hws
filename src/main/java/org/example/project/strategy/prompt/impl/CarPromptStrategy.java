package org.example.project.strategy.prompt.impl;

import org.example.project.strategy.prompt.Promptable;
import org.example.project.util.AppUtils;

public class CarPromptStrategy implements Promptable {
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
