package org.example.project.service.strategy.prompt.impl;

import org.example.project.service.strategy.prompt.PromptStrategy;
import org.example.project.util.AppUtils;

public class RootCropPromptStrategy implements PromptStrategy {

    @Override
    public String prompt() {
        return "RootCrop," +
                AppUtils.prompt("Введите тип корнеплода:\n") +
                "," +
                AppUtils.prompt("Введите вес корнеплода:\n") +
                "," +
                AppUtils.prompt("Введите цвет корнеплода:\n");
    }
}
