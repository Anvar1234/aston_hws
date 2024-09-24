package org.example.project.strategy.validation;

public class DataValidator<T> {
    private final ValidationStrategy<T> validation;

    public DataValidator(ValidationStrategy<T> validation) {
        this.validation = validation;
    }

    public boolean isValid(T product){
        return this.validation.validate(product);
    }
}
