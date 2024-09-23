package org.example.project.strategy.input;

import java.io.IOException;
import java.util.List;

public class GeneralDataInput<T> {
    InputStrategy<T> inputStrategy;

    public GeneralDataInput(InputStrategy<T> inputStrategy) {
        this.inputStrategy = inputStrategy;
    }

    public List<T> inputData(int count) throws IOException {
        return this.inputStrategy.input(count);
    }
}
