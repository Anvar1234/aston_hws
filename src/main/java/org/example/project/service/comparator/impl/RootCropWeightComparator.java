package org.example.project.service.comparator.impl;

import org.example.project.model.impl.Book;
import org.example.project.model.impl.RootCrop;
import org.example.project.service.comparator.ProductComparable;

public class RootCropWeightComparator implements ProductComparable<RootCrop> {
    @Override
    public int compare(RootCrop rootCrop1, RootCrop rootCrop2) {
        return Integer.compare(rootCrop1.getWeight(), rootCrop2.getWeight());
    }
}
