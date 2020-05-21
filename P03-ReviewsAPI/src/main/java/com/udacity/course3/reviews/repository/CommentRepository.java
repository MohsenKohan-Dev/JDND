package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data Respository for {@link Comment} entity.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    /**
     * Find all {@link Comment} for a review.
     *
     * @param review The {@link Review} object.
     * @return The list of comments for a review.
     */
    List<Comment> findAllByReview(Review review);
}
