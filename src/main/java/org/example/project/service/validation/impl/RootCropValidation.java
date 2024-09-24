package org.example.project.service.validation.impl;

import org.example.project.model.RootCrop;
import org.example.project.service.validation.Validationable;

public class RootCropValidation implements Validationable<RootCrop> {
    @Override
    public boolean validate(RootCrop product) {
        return product.getType() != null &&
                !product.getType().isEmpty() &&
                product.getWeight() > 0 &&
                product.getColor() != null &&
                !product.getColor().isEmpty();
    }
}
