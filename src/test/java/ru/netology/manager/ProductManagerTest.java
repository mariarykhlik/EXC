package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {

    Product book = new Book("ISBN123","JavaQA", 2000, "F.Voronov");
    Product smartphone = new Smartphone("S/N123","J-Fold", 200000, "Samsung");
    Product simplyProduct = new Product("321", "something", 100);

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    @Test
    public void shouldAddProduct() {

        manager.addProduct(book);
        manager.addProduct(smartphone);
        manager.addProduct(simplyProduct);

        Product[] expected = {book, smartphone, simplyProduct};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByQuery() {

        manager.addProduct(book);
        manager.addProduct(smartphone);
        manager.addProduct(simplyProduct);

        Product[] actual = manager.searchBy("J");

        Product[] expected = {book, smartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByQueryAndFindNot() {

        manager.addProduct(book);
        manager.addProduct(smartphone);
        manager.addProduct(simplyProduct);

        Product[] actual = manager.searchBy("0");

        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }
}
