package org.example.project.strategy.validation.impl;

import org.example.project.model.Car;
import org.example.project.strategy.validation.ValidationStrategy;

public class CarValidationStrategy implements ValidationStrategy<Car> {
    @Override
    public boolean validate(Car product) {
        return product.getModel() != null &&
                !product.getModel().isEmpty() &&
                product.getPower()> 0 &&
                product.getYear() > 1885;
    }
}
