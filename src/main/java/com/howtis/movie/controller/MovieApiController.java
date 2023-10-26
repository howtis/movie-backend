package com.howtis.movie.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.howtis.api.client.domain.MovieDetail;
import com.howtis.api.client.domain.MovieImage;
import com.howtis.api.client.domain.MovieResponse;
import com.howtis.api.client.domain.MovieVideo;
import com.howtis.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MovieApiController {

    private final MovieService movieService;
    private final ObjectMapper objectMapper;

    @GetMapping("/nowplaying")
    String nowplaying() throws JsonProcessingException {
        MovieResponse nowPlaying = movieService.getNowPlaying();
        return objectMapper.writeValueAsString(nowPlaying);
    }

    @GetMapping("/upcoming")
    String upcoming() throws JsonProcessingException {
        MovieResponse upcoming = movieService.getUpcoming();
        return objectMapper.writeValueAsString(upcoming);
    }

    @GetMapping("/genre")
    String genre() throws JsonProcessingException {
        MovieResponse genre = movieService.getByRandomGenre();
        return objectMapper.writeValueAsString(genre);
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable int id) throws JsonProcessingException {
        MovieDetail detail = movieService.getMovieDetail(id);
        return objectMapper.writeValueAsString(detail);
    }

    @GetMapping("/videos/{id}")
    String videos(@PathVariable int id) throws JsonProcessingException {
        MovieVideo video = movieService.getMovieVideo(id);
        return objectMapper.writeValueAsString(video);
    }

    @GetMapping("/images/{id}")
    String images(@PathVariable int id) throws JsonProcessingException {
        MovieImage image = movieService.getMovieImage(id);
        return objectMapper.writeValueAsString(image);
    }

    @GetMapping("/similar/{id}")
    String similar(@PathVariable int id) throws JsonProcessingException {
        MovieResponse similar = movieService.getSimilarMovie(id);
        return objectMapper.writeValueAsString(similar);
    }

    @GetMapping("/search")
    String search(@RequestParam String query, @RequestParam int page) throws JsonProcessingException {
        MovieResponse search = movieService.searchMovie(query, page);
        return objectMapper.writeValueAsString(search);
    }
}

