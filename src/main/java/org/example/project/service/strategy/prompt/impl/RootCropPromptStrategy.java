package org.example.project.service.strategy.prompt.impl;

import org.example.project.service.strategy.prompt.PromptStrategy;
import org.example.project.util.AppUtils;

public class RootCropPromptStrategy implements PromptStrategy {

    @Override
    public String prompt() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RootCrop,");
        stringBuilder.append(AppUtils.prompt("Введите тип корнеплода:\n"));
        stringBuilder.append(",");
        stringBuilder.append(AppUtils.prompt("Введите вес корнеплода:\n"));
        stringBuilder.append(",");
        stringBuilder.append(AppUtils.prompt("Введите цвет корнеплода:\n"));
        return stringBuilder.toString();
    }
}
