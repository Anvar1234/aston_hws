package org.example.project.service.strategy.input;

import java.io.IOException;
import java.util.List;

public class DataInputter<T> {
    InputStrategy<T> inputStrategy;

    public DataInputter(InputStrategy<?> inputStrategy) {
        this.inputStrategy = (InputStrategy<T>) inputStrategy;
    }

    public List<T> input(int count) throws IOException {
        return this.inputStrategy.input(count);
    }

    public InputStrategy<T> getInputStrategy() {
        return inputStrategy;
    }
}
