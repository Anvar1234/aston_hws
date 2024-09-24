package org.example.project.strategy.validation.impl;

import org.example.project.model.Book;
import org.example.project.strategy.validation.ValidationStrategy;

public class BookValidationStrategy implements ValidationStrategy<Book> {
    @Override
    public boolean validate(Book product) {
        return product.getAuthor() != null &&
                !product.getAuthor().isEmpty() &&
                product.getTitle() != null &&
                !product.getTitle().isEmpty() &&
                product.getPages() > 0;
    }
}
