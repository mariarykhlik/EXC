package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {

    Product book = new Book("ISBN123","Java basic", 2000, "F.Voronov");
    Product smartphone = new Smartphone("S/N123","J-Fold", 200000, "Samsung");
    Product simplyProduct = new Product("321", "something", 100);

    ProductRepository repository = new ProductRepository();

    @Test
    public void shouldFindAll() {

        Product[] actual = repository.findAll();

        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveProduct() {

        repository.saveProduct(book);
        repository.saveProduct(smartphone);
        repository.saveProduct(simplyProduct);

        Product[] expected = {book, smartphone, simplyProduct};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {

        repository.saveProduct(book);
        repository.saveProduct(smartphone);
        repository.saveProduct(simplyProduct);

        repository.removeById("321");

        Product[] expected = {book, smartphone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFoundException() {

        repository.saveProduct(book);
        repository.saveProduct(smartphone);
        repository.saveProduct(simplyProduct);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById("4");
        });
    }
}
