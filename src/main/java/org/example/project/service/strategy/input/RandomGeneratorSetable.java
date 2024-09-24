package org.example.project.service.strategy.input;

import org.example.project.service.strategy.random.RandomDataGenerator;

public interface RandomGeneratorSetable {

    void setRandomGeneratorStrategy(RandomDataGenerator<?> generator);
}
