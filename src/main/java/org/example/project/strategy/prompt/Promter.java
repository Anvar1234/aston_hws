package org.example.project.strategy.prompt;

public class Promter {
    private final Promptable promptable;

    public Promter(Promptable promptable) {
        this.promptable = promptable;
    }
    public String promptInfo(){
        return this.promptable.prompt();
    }
}
