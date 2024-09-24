package org.example.project.strategy.prompt;

public class ProductPrompter {
    private final Promptable promptable;

    public ProductPrompter(Promptable promptable) {
        this.promptable = promptable;
    }

    public String promptInfo() {
        return this.promptable.prompt();
    }
}
