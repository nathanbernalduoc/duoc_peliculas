package com.nathan.duoc_peliculas.service;

import java.util.Optional;
import java.util.List;

import com.nathan.duoc_peliculas.modelsDto.MessageDto;
import com.nathan.duoc_peliculas.modelsDto.MovieDto;

public interface MovieService {
    List<MovieDto> getAllMovie();
    Optional<MovieDto> getMovieById(Long id);

    // CRUD
    MovieDto createMovie(MovieDto movie);
    MovieDto updateMovie(Long id, MovieDto movie);
    MessageDto deleteMovie(Long id);
    
}
