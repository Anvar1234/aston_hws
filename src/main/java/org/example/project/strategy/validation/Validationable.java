package org.example.project.strategy.validation;

public interface Validationable<T> {
    boolean validate(T product);
}
