package com.howtis.movie.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Getter
@Table(name = "review")
@Entity
@ToString
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("movie_id")
    private String movieId;

    private Short rating;

    private String comment;

    @JsonProperty("created_at")
    private Date createdAt;

    @Builder
    public Review(Long id, String movieId, Short rating, String comment, Date createdAt) {
        this.id = id;
        this.movieId = movieId;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = createdAt;
    }
}