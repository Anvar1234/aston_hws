package org.example.project.strategy.input;

import org.example.project.strategy.prompt.ProductPrompter;

public interface PromptSetable {
    void setPromptStrategy(ProductPrompter promptStrategy);
}
