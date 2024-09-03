package com.nathan.duoc_peliculas.controllers;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nathan.duoc_peliculas.modelsDto.MovieDto;
import com.nathan.duoc_peliculas.service.MovieService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/peliculas")

public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<MovieDto> getAllMovieDtos() {
        return movieService.getAllMovie();
    }
    
    @GetMapping({"/{id}"})
    public Optional<MovieDto> getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

}
