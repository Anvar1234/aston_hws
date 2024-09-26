package org.example.project.service.validation.impl;

import org.example.project.model.impl.Book;
import org.example.project.service.validation.Validationable;

public class BookValidation implements Validationable<Book> {
    @Override
    public boolean validate(Book product) {
        return product.getAuthor() != null &&
                !product.getAuthor().isEmpty() &&
                product.getTitle() != null &&
                !product.getTitle().isEmpty() &&
                product.getPages() > 0;
    }
}
