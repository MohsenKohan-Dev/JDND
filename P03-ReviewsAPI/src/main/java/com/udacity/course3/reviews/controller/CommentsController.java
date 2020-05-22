package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments/reviews")
public class CommentsController {

    private final ReviewRepository reviewRepository;

    public CommentsController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    /**
     * Creates a comment for a review.
     * <p>
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @PostMapping("/{reviewId}")
    public ResponseEntity<Comment> createCommentForReview(@PathVariable("reviewId") String reviewId,
                                                          @RequestBody Comment comment) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);

        if (optionalReview.isEmpty())
            return ResponseEntity.notFound().build();

        Review review = optionalReview.get();
        review.addComment(comment);
        reviewRepository.save(review);

        return ResponseEntity.ok(comment);
    }

    /**
     * List comments for a review.
     * <p>
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @GetMapping("/{reviewId}")
    public ResponseEntity<List<Comment>> listCommentsForReview(@PathVariable("reviewId") String reviewId) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);

        if (optionalReview.isEmpty())
            return ResponseEntity.notFound().build();

        Review review = optionalReview.get();
        List<Comment> allByReview = review.getComments();

        return ResponseEntity.ok(allByReview);
    }
}