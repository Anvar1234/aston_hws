package org.example.project.validation;

public interface Validationable<T> {
    boolean validate(T product);
}
