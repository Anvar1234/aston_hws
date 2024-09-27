package org.example.project.model;

public class Book implements Comparable<Book>{
    private final String author;
    private final String title;
    private final int pages;

    private Book(BookBuilder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.pages = builder.pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title); // Сортировка по названию по умолчанию
    }

    @Override
    public String toString() {
        return "Книга: автор= " + author + ", название= " + title + ", кол-во страниц= " + pages;
    }

    // Внутренний класс билдер
    public static class BookBuilder {
        private String author;
        private String title;
        private int pages;

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setPages(int pages) {
            this.pages = pages;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}