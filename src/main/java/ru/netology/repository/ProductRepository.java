package ru.netology.repository;

import ru.netology.domain.Product;

import java.util.Objects;

public class ProductRepository {

    private Product[] products = new Product[0];

    public void saveProduct(Product product) {
        Product[] tmp = new Product[products.length + 1];
        System.arraycopy(products, 0, tmp, 0, products.length);
        tmp[products.length] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void removeById(String id) {
        if (Objects.equals(findById(id), null)) {
            throw new NotFoundException("Element with id " + id + " not found");
        }
        int index = 0;
        Product[] tmp = new Product[products.length - 1];
        for (int i = 0; i < products.length; i++) {
            if (!products[i].equals(findById(id))) {
                tmp[index] = products[i];
                index++;
            }
        }
        products = tmp;
    }
}
