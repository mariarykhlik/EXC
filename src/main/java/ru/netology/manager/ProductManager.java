package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {

    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product product) {
        repository.saveProduct(product);
    }

    public Product[] searchBy(String search) {
        Product[] result = new Product[0];
        for (Product product: repository.findAll()) {
            if (product.match(search)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[result.length] = product;
                result = tmp;
            }
        }
        return result;
    }
}
