package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        Product product1 = new Product(1);
        Product product2 = new Product(2);
        productRepository.save(product1);
        productRepository.save(product2);
    }

    @Test
    void findByIdTest() {
        assertEquals(new Product(1), productRepository.findById(1).get());
    }
}
