package com.nathan.duoc_peliculas.controllers;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nathan.duoc_peliculas.modelsDto.MessageDto;
import com.nathan.duoc_peliculas.modelsDto.MovieDto;
import com.nathan.duoc_peliculas.service.MovieService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



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

    // CRUD
    @PostMapping
    public MovieDto createMovie(@RequestBody MovieDto movie) {
        return movieService.createMovie(movie);
    }
    
    @PutMapping("/{id}")
    public MovieDto updateMovieDto(@PathVariable Long id, @RequestBody MovieDto movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public MessageDto deleteMovie(@PathVariable Long id) {
        return movieService.deleteMovie(id);
    }
}
