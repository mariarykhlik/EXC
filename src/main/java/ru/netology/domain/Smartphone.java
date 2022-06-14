package ru.netology.domain;

public class Smartphone extends Product {

    private String manufacturer;

    public Smartphone(String id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean match(String search) {
        if (super.match(search)) {
            return true;
        } else {
            return manufacturer.contains(search);
        }
    }
}
