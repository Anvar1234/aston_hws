package org.example.project.strategy.parser;

import java.io.IOException;
import java.util.Optional;

public class ProductParser<T> {
    private final Parser<T> parser;

    public ProductParser(Parser<T> parser) {
        this.parser = parser;
    }

    public Optional<T> parseProduct(String line) throws IOException {
        return parser.parse(line);
    }
}
