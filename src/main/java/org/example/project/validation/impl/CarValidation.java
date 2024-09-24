package org.example.project.validation.impl;

import org.example.project.model.Car;
import org.example.project.validation.Validationable;

public class CarValidation implements Validationable<Car> {
    @Override
    public boolean validate(Car product) {
            return product.getModel() != null &&
                    !product.getModel().isEmpty() &&
                    product.getPower() > 0 &&
                    product.getYear() > 1885;
    }
}
