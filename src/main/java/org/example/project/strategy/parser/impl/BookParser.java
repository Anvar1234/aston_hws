package org.example.project.strategy.parser.impl;

import org.example.project.model.Book;
import org.example.project.strategy.parser.Parser;

import java.io.IOException;
import java.util.Optional;

public class BookParser implements Parser<Book> {
    @Override
    public Optional<Book> parse(String line) throws IOException {
        Book book = null;
        String[] parts = line.split(",");  // Предполагаем, что данные в файле разделены запятыми
        if (parts.length != 3) {
            throw new IOException("Ошибка в чтения строки!");
        }
        try {
            book = new Book.BookBuilder() //TODO добавить проверки корректности ТИПА вводимых значений.
                    .setAuthor(parts[0])
                    .setTitle(parts[1])
                    .setPages(Integer.parseInt(parts[2]))
                    .build();
        } catch (NumberFormatException e) {
            System.out.println(e); // TODO нормально везде обработать.
        }
        return Optional.ofNullable(book);
    }
}
