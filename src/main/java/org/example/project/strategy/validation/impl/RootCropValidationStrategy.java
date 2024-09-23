package org.example.project.strategy.validation.impl;

import org.example.project.model.RootCrop;
import org.example.project.strategy.validation.Validationable;

public class RootCropValidationStrategy implements Validationable<RootCrop> {
    @Override
    public boolean validate(RootCrop product) {
        return product.getType() != null &&
                !product.getType().isEmpty() &&
                product.getWeight() > 0 &&
                product.getColor() != null &&
                !product.getColor().isEmpty();
    }
}
