package org.example.project.strategy.parser;

import java.io.IOException;
import java.util.Optional;

public interface Parser<T> {
    Optional<T> parse(String line) throws IOException;
}
