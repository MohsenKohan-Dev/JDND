ALTER TABLE review Add CONSTRAINT review_product_id_fk FOREIGN KEY (product_id) REFERENCES product (id);
ALTER TABLE comment Add CONSTRAINT comment_review_id_fk FOREIGN KEY (review_id) REFERENCES review (id);
