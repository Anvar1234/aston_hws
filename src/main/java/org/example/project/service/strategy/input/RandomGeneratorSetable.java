package org.example.project.service.strategy.input;

import org.example.project.service.strategy.random.RandomFillinger;

public interface RandomGeneratorSetable {

    void setRandomGeneratorStrategy(RandomFillinger<?> generator);
}
