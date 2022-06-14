package ru.netology.domain;

public class Product {

    protected String id;
    protected String name;
    protected int price;

    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean match(String search) {
        return getName().contains(search);
    }
}
