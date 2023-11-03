package com.howtis.movie.controller;

import com.howtis.movie.domain.entity.Review;
import com.howtis.movie.mapper.ReviewMapper;
import com.howtis.movie.repository.ReviewRepository;
import com.howtis.movie.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @PostMapping("/create")
    Review create(@RequestBody Review review) {
        return reviewService.save(review);
    }

    @GetMapping("/list/{movieId}")
    Page<Review> list(@PathVariable String movieId, Pageable pageable) {
        return reviewRepository.findByMovieIdOrderByCreatedAtDesc(movieId, pageable);
    }

    @GetMapping("/rating/{movieId}")
    Float getRating(@PathVariable String movieId) {
        return reviewMapper.getAverageRatingByMovieId(movieId);
    }
}
