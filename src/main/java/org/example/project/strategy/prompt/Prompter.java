package org.example.project.strategy.prompt;

public class Prompter {
    private final Promptable promptable;

    public Prompter(Promptable promptable) {
        this.promptable = promptable;
    }
    public String promptInfo(){
        return this.promptable.prompt();
    }
}
