package com.nathan.duoc_peliculas.controllers;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nathan.duoc_peliculas.modelsDto.MessageDto;
import com.nathan.duoc_peliculas.modelsDto.MovieDto;
import com.nathan.duoc_peliculas.service.MovieService;

import java.util.stream.Collectors;

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
    public CollectionModel<EntityModel<MovieDto>> getAllMovies() {

        List<MovieDto> movies = movieService.getAllMovie();

        List<EntityModel<MovieDto>> movieResources = movies.stream()
            .map(movie -> EntityModel.of(movie,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getMovieById(movie.getId())).withSelfRel()
                ))
            .collect(Collectors.toList());  

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllMovies());
        CollectionModel<EntityModel<MovieDto>> resources = CollectionModel.of(movieResources, linkTo.withRel("pelicula"));

        return resources;
    }
    
    @GetMapping({"/{id}"})
    public EntityModel<MovieDto> getMovieById(@PathVariable Long id) {

        Optional<MovieDto> movie = movieService.getMovieById(id);

        if (movie.isPresent()) {

            return EntityModel.of(movie.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getMovieById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllMovies()).withRel("peliculas-all"));
        
        } else {

            throw new MovieNotFoundException("Película no encontrado: " + id);

        }

    }

    // CRUD
    @PostMapping
    public EntityModel<MovieDto> createMovie(@RequestBody MovieDto movie) {

        MovieDto createdMovie = movieService.createMovie(movie);
        return EntityModel.of(createdMovie,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getMovieById(createdMovie.getId())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllMovies()).withRel("peliculas-all"));

    }
    
    @PutMapping("/{id}")
    public EntityModel<MovieDto> updateMovieDto(@PathVariable Long id, @RequestBody MovieDto movie) {

        MovieDto updatedMovie = movieService.updateMovie(id, movie);
        return EntityModel.of(updatedMovie,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getMovieById(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllMovies()).withRel("peliculas-all"));
    }

    @DeleteMapping("/{id}")
    public MessageDto deleteMovie(@PathVariable Long id) {
        return movieService.deleteMovie(id);
    }
}
