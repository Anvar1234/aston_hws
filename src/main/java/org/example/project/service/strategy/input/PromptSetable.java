package org.example.project.service.strategy.input;

import org.example.project.service.strategy.prompt.ProductPrompter;

public interface PromptSetable {
    void setPromptStrategy(ProductPrompter promptStrategy);
}
