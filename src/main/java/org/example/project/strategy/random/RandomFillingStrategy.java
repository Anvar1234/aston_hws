package org.example.project.strategy.random;

import java.util.List;

public interface RandomFillingStrategy<T> {
    List<T> generateRandomData(int count);
}
