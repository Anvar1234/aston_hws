package org.example.project.strategy.validation;

public interface ValidationStrategy<T> {
    boolean validate(T product);
}
