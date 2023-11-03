package com.howtis.movie.service;

import com.howtis.movie.domain.RecaptchaResponse;
import com.howtis.movie.domain.entity.Review;
import com.howtis.movie.repository.ReviewRepository;
import com.howtis.movie.utils.ReCaptchaValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReCaptchaValidator reCaptchaValidator;

    private static final double HUMAN_SCORE = 0.5;

    public Review save(Review review) {
        RecaptchaResponse response = reCaptchaValidator.request(review.getToken());
        return response.getScore() > HUMAN_SCORE
                ? reviewRepository.save(review)
                : null; // TODO reCaptcha score 결과에 따른 제대로 된 응답으로 전환
    }
}
