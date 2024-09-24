package org.example.project.service.validation;

public interface Validationable<T> {
    boolean validate(T product);
}
