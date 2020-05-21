package com.udacity.course3.reviews.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String reviewText;
    private boolean recommended;

    @ManyToOne
    private Product product;

    public Review(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", recommended=" + recommended +
                ", product=" + product +
                '}';
    }
}
