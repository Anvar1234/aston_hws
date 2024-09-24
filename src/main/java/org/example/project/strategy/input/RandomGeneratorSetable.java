package org.example.project.strategy.input;

import org.example.project.strategy.random.RandomDataGenerator;

public interface RandomGeneratorSetable {

    void setRandomGeneratorStrategy(RandomDataGenerator<?> generator);
}
