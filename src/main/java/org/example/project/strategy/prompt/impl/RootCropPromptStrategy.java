package org.example.project.strategy.prompt.impl;

import org.example.project.strategy.prompt.Promptable;
import org.example.project.util.AppUtils;

public class RootCropPromptStrategy implements Promptable {

    @Override
    public String prompt() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppUtils.prompt("Введите тип корнеплода:\n"));
        stringBuilder.append(",");
        stringBuilder.append(AppUtils.prompt("Введите вес корнеплода:\n"));
        stringBuilder.append(",");
        stringBuilder.append(AppUtils.prompt("Введите цвет корнеплода:\n"));
        return stringBuilder.toString();
    }
}
