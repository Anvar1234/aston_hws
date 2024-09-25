package org.example.project.service.strategy.input;

import org.example.project.service.strategy.parse.ProductParser;

public interface ParseSetable {
    void setParseStrategy(ProductParser<?> parser);
}
