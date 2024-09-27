package org.example.project.service.strategy.random.impl;

import org.example.project.model.RootCrop;
import org.example.project.service.strategy.random.RandomFillingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomRootCropsStrategy implements RandomFillingStrategy<RootCrop> {
    @Override
    public List<RootCrop> generateRandomData(int count) {
        Random random = new Random();
        List<RootCrop> crops = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            crops.add(new RootCrop.RootCropBuilder()
                    .setType("Тип" + random.nextInt(1, 100))
                    .setWeight((int) (Math.random() * 10.0 + 1.0))
                    .setColor("Цвет" + random.nextInt(1, 100)) //TODO сделать енам для цвета
                    .build());
        }
        return crops;
    }
}
