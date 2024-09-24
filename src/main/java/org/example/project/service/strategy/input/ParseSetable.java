package org.example.project.service.strategy.input;

import org.example.project.service.strategy.parser.ProductParser;

public interface ParseSetable {
    void setParseStrategy(ProductParser<?> parser);
}
