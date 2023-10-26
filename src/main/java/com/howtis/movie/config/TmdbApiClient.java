package com.howtis.movie.config;

import com.howtis.api.client.TmdbApiClientFactory;
import com.howtis.api.client.TmdbApiRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TmdbApiClient {

    @Value("${tmdb.api-key}")
    private String apiKey;

    @Value("${tmdb.api-access-token}")
    private String apiAccessToken;

    @Bean
    TmdbApiRestClient tmdbApiRestClient() {
        return TmdbApiClientFactory.newInstance(apiAccessToken).newRestClient();
    }
}
