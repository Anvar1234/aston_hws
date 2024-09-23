package org.example.project.strategy.validation;

public class DataValidator<T> {
    private final Validationable<T> validation;

    public DataValidator(Validationable<T> validation) {
        this.validation = validation;
    }

    public boolean isValid(T product){
        return this.validation.validate(product);
    }
}
