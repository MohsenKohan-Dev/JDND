package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {

    List<Review> findAllByProductId(Integer id);
}
