package com.howtis.movie.mapper;

import com.howtis.movie.domain.entity.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<Review> findByMovieId(@Param("movieId") String movieId);
}
