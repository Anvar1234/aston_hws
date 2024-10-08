package org.example.project.service.strategy.random.impl;

import org.example.project.model.Book;
import org.example.project.service.strategy.random.RandomFillingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBookStrategy implements RandomFillingStrategy<Book> {
    @Override
    public List<Book> generateRandomData(int count) {
        Random random = new Random();
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            books.add(new Book.BookBuilder()
                    .setAuthor("Автор" + random.nextInt(1, 100))
                    .setTitle("Название" + random.nextInt(1, 100))
                    .setPages((int) (Math.random() * 1000 + 50))
                    .build());
        }
        return books;
    }
}
