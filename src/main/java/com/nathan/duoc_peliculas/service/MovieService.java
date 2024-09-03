package com.nathan.duoc_peliculas.service;

import java.util.Optional;
import java.util.List;
import com.nathan.duoc_peliculas.modelsDto.MovieDto;

public interface MovieService {
    List<MovieDto> getAllMovie();
    Optional<MovieDto> getMovieById(Long id);
}
