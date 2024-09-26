package org.example.project.service.validation.impl;

import org.example.project.model.impl.Car;
import org.example.project.service.validation.Validationable;

public class CarValidation implements Validationable<Car> {
    @Override
    public boolean validate(Car product) {
            return product.getModel() != null &&
                    !product.getModel().isEmpty() &&
                    product.getPower() > 0 &&
                    product.getYear() > 1885;
    }
}
