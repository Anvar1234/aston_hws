package org.example.project.strategy.parser.impl;

import org.example.project.model.Book;
import org.example.project.strategy.parser.ParseStrategy;
import org.example.project.util.AppUtils;
import org.example.project.validation.impl.BookValidation;

import java.io.IOException;
import java.util.Optional;

public class BookParseStrategy implements ParseStrategy<Book> {
    @Override
    public Optional<Book> parse(String line) {
        Book book;
        String[] parts = line.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Некорректное количество параметров в строке.");
        }
        if(!parts[0].toLowerCase().equalsIgnoreCase(Book.class.getSimpleName())){
            throw new IllegalArgumentException("Выбранный тип продукта и тип из файла не совпадают!");
        }
        try {
            book = new Book.BookBuilder() //TODO добавить проверки корректности ТИПА вводимых значений.
                    .setAuthor(parts[1])
                    .setTitle(parts[2])
                    .setPages(AppUtils.parseInteger(parts[3], "Количество страниц должно быть числом."))
                    .build();
            if (!new BookValidation().validate(book)) {
                throw new IllegalArgumentException("Данные для полей не валидны.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Тип данных после парсинга некорректен." + e.getMessage());
        }
        return Optional.of(book);
    }
}
