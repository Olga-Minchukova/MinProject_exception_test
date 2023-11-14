package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    ru.netology.ShopRepository repo = new ru.netology.ShopRepository();

    ru.netology.Product product1 = new ru.netology.Product(1, "T-shirt", 1990);
    ru.netology.Product product2 = new ru.netology.Product(2, "Book", 399);
    ru.netology.Product product3 = new ru.netology.Product(3, "Milk", 69);


    @Test
    public void shouldAddProductInRepository() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        ru.netology.Product[] expected = { product1, product2, product3 };
        ru.netology.Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteProductInRepository() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(1);

        Product[] expected = { product2, product3 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(77);
        });
    }

}
