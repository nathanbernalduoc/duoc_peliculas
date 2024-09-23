package com.nathan.duoc_peliculas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.nathan.duoc_peliculas.modelsDto.MovieDto;
import com.nathan.duoc_peliculas.repository.MovieRepository;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @InjectMocks
    private MovieServiceImpl movieService;

    @Mock
    private MovieRepository movieRepositoryMock;

    @Test
    public void setMovieTest() {

        String titulo = "Testeando servicio";
        // Arange
        MovieDto movie = new MovieDto();
        movie.setAnio(1980);
        movie.setDirector("Carlos");
        movie.setGenero(2L);
        movie.setSinopsis("Prueba de nueva película #1000");
        movie.setTitulo(titulo);

        when(movieRepositoryMock.save(any())).thenReturn(movie);

        // Act
        MovieDto movieResult = movieService.createMovie(movie);

        // Assert
        assertEquals(titulo, movieResult.getTitulo());
    }

    @Test
    public void setMovieTest2() {

        String titulo = "Testeando servicio #2";
        // Arange
        MovieDto movie = new MovieDto();
        movie.setAnio(1980);
        movie.setDirector("Carlos");
        movie.setGenero(2L);
        movie.setSinopsis("Prueba de nueva película #1000");
        movie.setTitulo(titulo);

        when(movieRepositoryMock.save(any())).thenReturn(movie);

        // Act
        MovieDto movieResult = movieService.createMovie(movie);

        // Assert
        assertEquals(titulo, movieResult.getTitulo());
    }

}
