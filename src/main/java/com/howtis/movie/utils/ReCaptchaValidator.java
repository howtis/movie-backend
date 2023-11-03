package com.howtis.movie.utils;

import com.howtis.movie.domain.RecaptchaResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ReCaptchaValidator {

    @Value("${recaptcha.secretkey}")
    public String secretKey;

    public RecaptchaResponse request(String token) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("secret", secretKey);
        parameters.add("response", token);

        WebClient webClient = WebClient.builder()
            .baseUrl("https://www.google.com/recaptcha").build();

        Mono<RecaptchaResponse> response = webClient.post()
                .uri("/api/siteverify")
                .body(BodyInserters.fromFormData(parameters))
                .retrieve().bodyToMono(RecaptchaResponse.class);

        return response.block();
    }
}
