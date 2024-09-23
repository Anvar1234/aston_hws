package org.example.project.strategy.input;

import java.io.IOException;
import java.util.List;

public interface InputStrategy<T>{
    List<T> input(int count) throws IOException;
}