package org.example.project.service.strategy.input.impl;

import org.example.project.service.strategy.input.InputStrategy;
import org.example.project.service.strategy.input.RandomGeneratorSetable;
import org.example.project.service.strategy.random.RandomFillinger;

import java.util.List;

public class RandomInputStrategy<T> implements InputStrategy<T>, RandomGeneratorSetable {
    private RandomFillinger<T> generator;
    // TODO: добавить аннотацию SuppressWarnings("unchecked") везде, где необходимо.
    @Override
    public void setRandomGeneratorStrategy(RandomFillinger<?> generator) {
        this.generator = (RandomFillinger<T>) generator;
    }

    @Override
    public List<T> input(int count) {
        return generator.getRandomData(count);
    }
}
