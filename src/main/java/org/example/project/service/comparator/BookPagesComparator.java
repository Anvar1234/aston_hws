package org.example.project.service.comparator;

import org.example.project.model.Book;

import java.util.Comparator;

public class BookPagesComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return Integer.compare(book1.getPages(), book2.getPages());
    }
}

