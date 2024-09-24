package org.example.project.strategy.input.impl;

import org.example.project.strategy.input.InputStrategy;
import org.example.project.strategy.input.RandomGeneratorSetable;
import org.example.project.strategy.random.RandomDataGenerator;

import java.util.List;

public class RandomInputStrategy<T> implements InputStrategy<T>, RandomGeneratorSetable {
    private RandomDataGenerator<T> generator;

    @Override
    public void setRandomGeneratorStrategy(RandomDataGenerator<?> generator) {
        this.generator = (RandomDataGenerator<T>) generator;
    }

    @Override
    public List<T> input(int count) {
        return generator.getRandomData(count);
    }
}
