package com.nathan.duoc_peliculas.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nathan.duoc_peliculas.modelsDto.MovieDto;

@RestController
public class MovieController {

    private List<MovieDto> movies = new ArrayList<>();

    public MovieController() {
        movies.add(new MovieDto(1, "American Fiction", 2023, "Cord Jefferson", "Comedia. Drama | Literatura. Familia. Comedia dramática. Sátira", "Harto de que las clases dirigentes se lucren a costa del entretenimiento negro que recurre a clichés ofensivos, un novelista frustrado decide escribir un estrafalario libro negro que lo sumirá de pleno en la hipocresía que él critica."));
        movies.add(new MovieDto(2, "Anatomía de una caída", 2011, "Juan Pérez #2", "Genérico #2", "Esta es una prueba de sinopsis #2"));
        movies.add(new MovieDto(3, "Barbie", 2012, "Juan Pérez #3", "Genérico #3", "Esta es una prueba de sinopsis #3"));
        movies.add(new MovieDto(4, "Los que se quedan", 2013, "Juan Pérez #4", "Genérico #4", "Esta es una prueba de sinopsis #4"));
        movies.add(new MovieDto(5, "Los asesinos de la luna", 2014, "Juan Pérez #5", "Genérico #5", "Esta es una prueba de sinopsis #5"));
        movies.add(new MovieDto(6, "Maestro", 2015, "Juan Pérez #6", "Genérico #6", "Esta es una prueba de sinopsis #6"));
        movies.add(new MovieDto(7, "Oppenheimer", 2016, "Juan Pérez #7", "Genérico #7", "Esta es una prueba de sinopsis #7"));
        movies.add(new MovieDto(8, "Vidas pasadas", 2017, "Juan Pérez #8", "Genérico #8", "Esta es una prueba de sinopsis #8"));
        movies.add(new MovieDto(9, "Pobres criaturas", 2018, "Juan Pérez #9", "Genérico #9", "Esta es una prueba de sinopsis #9"));
        movies.add(new MovieDto(10, "La zona de interés", 2019, "Juan Pérez #10", "Genérico #10", "Esta es una prueba de sinopsis #10"));
    }

    @GetMapping({"/peliculas", "/peliculas/"})
    public List<MovieDto> getMovies() {
        return movies;
    }

    @GetMapping("/peliculas/{id}")
    public MovieDto getMovie(@PathVariable int id) {
        for (MovieDto movie: movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

}
