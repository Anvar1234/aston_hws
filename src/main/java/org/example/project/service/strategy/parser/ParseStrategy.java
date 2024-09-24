package org.example.project.service.strategy.parser;

import java.io.IOException;
import java.util.Optional;

public interface ParseStrategy<T> {
    Optional<T> parse(String line) throws IOException;
}
