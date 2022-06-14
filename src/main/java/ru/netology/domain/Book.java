package ru.netology.domain;

public class Book extends Product {

    private String author;

    public Book(String id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    @Override
    public boolean match(String search) {
        if (super.match(search)) {
            return true;
        } else {
            return author.contains(search);
        }
    }
}
