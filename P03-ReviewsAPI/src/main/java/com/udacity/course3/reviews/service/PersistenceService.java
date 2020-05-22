package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersistenceService {

    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public PersistenceService(ProductRepository productRepository, ReviewRepository reviewRepository) {
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findReviewsByProductId(Integer productId) {
        productRepository.findById(productId).orElseThrow(NoSuchElementException::new);
        return reviewRepository.findAllByProductId(productId);
    }

    public Review insertReviewForProduct(Integer productId, Review review) {
        productRepository.findById(productId).orElseThrow(NoSuchElementException::new);
        review.setProductId(productId);
        return reviewRepository.insert(review);
    }
}
