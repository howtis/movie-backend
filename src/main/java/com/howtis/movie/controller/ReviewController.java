package com.howtis.movie.controller;

import com.howtis.movie.domain.entity.Review;
import com.howtis.movie.mapper.ReviewMapper;
import com.howtis.movie.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    @PostMapping("/create")
    Review create(@RequestBody Review review) {
        return reviewService.save(review);
    }

    @GetMapping("/list/{id}")
    List<Review> list(@PathVariable String id) {
        return reviewMapper.findByMovieId(id);
    }
}
