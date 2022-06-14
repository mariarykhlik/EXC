package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnyProductTest {

    Product book = new Book("ISBN123","JavaQA", 2000, "F.Voronov");
    Product smartphone = new Smartphone("S/N123","J-Fold", 200000, "Famfung");
    Product simplyProduct = new Product("321", "something", 100);

    @ParameterizedTest
    @CsvSource(value=
            {
                    "some, true",
                    "F, false"
            }
    )
    public void shouldMatchForSuper(String search, boolean expected) {

        Boolean actual = simplyProduct.match(search);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value=
            {
                    "F.V, true",
                    "0, false"
            }
    )
    public void shouldMatchForBook(String search, boolean expected) {

        Boolean actual = book.match(search);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value=
            {
                    "Fam, true",
                    "0, false"
            }
    )
    public void shouldMatchForSmartphone(String search, boolean expected) {

        Boolean actual = smartphone.match(search);

        assertEquals(expected, actual);
    }
}
