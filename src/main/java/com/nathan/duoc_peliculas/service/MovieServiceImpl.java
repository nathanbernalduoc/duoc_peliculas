package com.nathan.duoc_peliculas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathan.duoc_peliculas.modelsDto.MovieDto;
import com.nathan.duoc_peliculas.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<MovieDto> getAllMovie() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<MovieDto> getMovieById(Long id) {
        return movieRepository.findById(id);
    }
}
