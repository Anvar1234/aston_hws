package org.example.project.strategy.random.impl;

import org.example.project.model.Book;
import org.example.project.strategy.random.RandomFillingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBookStrategy implements RandomFillingStrategy<Book> {
    @Override
    public List<Book> generateRandomData(int count) {
        Random random = new Random(); //TODO убрать в рандомайзер
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            books.add(new Book.BookBuilder()
                    .setAuthor("Author" + random.nextInt(1, 100))
                    .setTitle("Title" + random.nextInt(1, 100))
                    .setPages((int) (Math.random() * 1000 + 50))
                    .build());
        }
        return books;
    }
}
