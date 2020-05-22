package com.udacity.course3.reviews.repository;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataMongoTest
class ReviewRepositoryTest {

    @Test
    void test(@Autowired MongoTemplate mongoTemplate) {
        Comment comment = new Comment("Good Product", "This product is awesome", Instant.now());
        Review review = new Review("1", "My Review");
        review.addComment(comment);

        mongoTemplate.insert(review, "reviews");

        assertTrue(mongoTemplate.findAll(Review.class, "reviews").contains(review));

        Review savedReview = mongoTemplate.findOne(
                Query.query(Criteria.where("title").is("My Review")),
                Review.class);

        assertEquals(review, savedReview);

        DBObject mongoObject = BasicDBObjectBuilder
                .start()
                .add("key", "value")
                .get();
        mongoTemplate.insert(mongoObject, "collection");
        assertThat(mongoTemplate.findAll(DBObject.class, "collection"))
                .extracting("key").containsOnly("value");
    }
}
