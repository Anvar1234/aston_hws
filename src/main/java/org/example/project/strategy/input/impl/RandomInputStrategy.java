package org.example.project.strategy.input.impl;

import org.example.project.strategy.input.InputStrategy;
import org.example.project.strategy.random.RandomDataGenerator;

import java.util.List;

public class RandomInputStrategy<T> implements InputStrategy<T> {
    private final RandomDataGenerator<T> generator;

    public RandomInputStrategy(RandomDataGenerator<T> generator) {
        this.generator = generator;
    }

    @Override
    public List<T> input(int count) {
        return generator.getRandomData(count);
    }
}
