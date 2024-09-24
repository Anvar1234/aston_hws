package org.example.project.strategy.input;

import org.example.project.strategy.parser.ProductParser;

public interface ParseSetable {
    void setParseStrategy(ProductParser<?> parser);
}
