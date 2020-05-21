package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ReviewsApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    void findProduct() {
        Product product1 = new Product(1, "iphone", "apple");
        Product product2 = new Product(2, "galaxy", "samsung");

        assertEquals(product1, productRepository.findById(1).get());
        assertEquals(product2, productRepository.findById(2).get());
    }
}