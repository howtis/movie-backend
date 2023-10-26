package com.howtis.movie.service;

import com.howtis.api.client.TmdbApiRestClient;
import com.howtis.api.client.domain.MovieDetail;
import com.howtis.api.client.domain.MovieImage;
import com.howtis.api.client.domain.MovieResponse;
import com.howtis.api.client.domain.MovieVideo;
import com.howtis.api.client.domain.values.MovieGenre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final TmdbApiRestClient tmdbApiRestClient;
    private final Random genreDice = new Random();

    public MovieResponse getNowPlaying() {
        Map<String, Object> queryMap = Collections.singletonMap("sort_by", "popularity.desc");
        return tmdbApiRestClient.discoverMovie(queryMap);
    }

    public MovieResponse getUpcoming() {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Map<String, Object> queryMap = Map.of("primary_release_date.gte", today,
                                              "sort_by", "primary_release_date.asc");
        return tmdbApiRestClient.discoverMovie(queryMap);
    }

    public MovieResponse getByRandomGenre() {
        MovieGenre[] genres = MovieGenre.values();
        MovieGenre randomGenre = genres[genreDice.nextInt(genres.length)];
        return getByGenre(randomGenre);
    }

    public MovieResponse getByGenre(MovieGenre genre) {
        Map<String, Object> queryMap = Map.of("with_genres", genre.getId(),
                                              "sort_by", "popularity.desc");
        return tmdbApiRestClient.discoverMovie(queryMap);
    }

    public MovieResponse getSimilarMovie(int id) {
        Map<String, Object> queryMap = Collections.singletonMap("sort_by", "popularity.desc");
        return tmdbApiRestClient.getSimilarMovie(id, queryMap);
    }

    public MovieResponse searchMovie(String query, int page) {
        Map<String, Object> queryMap = Map.of("query", query,
                                              "page", page);
        return tmdbApiRestClient.searchMovie(queryMap);
    }

    public MovieDetail getMovieDetail(int id) {
        return tmdbApiRestClient.getMovieDetail(id);
    }

    public MovieImage getMovieImage(int id) {
        return tmdbApiRestClient.getMovieImage(id);
    }

    public MovieVideo getMovieVideo(int id) {
        return tmdbApiRestClient.getMovieVideo(id);
    }
}
