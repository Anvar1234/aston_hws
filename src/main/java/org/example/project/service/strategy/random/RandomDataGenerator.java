package org.example.project.service.strategy.random;

import java.util.List;

public class RandomDataGenerator<T> {
    RandomFillingStrategy<T> random;

    public RandomDataGenerator(RandomFillingStrategy<T> random) {
        this.random = random;
    }
    public List<T> getRandomData(int count){
        return this.random.generateRandomData(count);
    }
}
