package com.howtis.movie.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewMapper {
    Float getAverageRatingByMovieId(@Param("movieId") String movieId);
}
