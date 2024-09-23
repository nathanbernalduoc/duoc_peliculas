package com.nathan.duoc_peliculas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.nathan.duoc_peliculas.modelsDto.MovieDto;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    TestEntityManager entityManager;

    

    @Test
    public void saveMovieTest() {
        String titulo = "Título de prueba para TEST JUNIT";
        // Arrange
        MovieDto movie = new MovieDto();
        movie.setTitulo(titulo);

        // Act
        MovieDto result = movieRepository.save(movie);

        // Assert
        assertNotNull(result.getId());
        assertEquals(titulo, result.getTitulo());
    }

    @Test
    public void newMovie() {
        MovieDto newMovie = new MovieDto(1L, "Película de prueba", 1990, "Nathan Bernal V.", 3L, "Había una vez una nueva historia que no quería ser contada");
        MovieDto insertedMovie = movieRepository.save(newMovie);
        assertThat(entityManager.find(MovieDto.class, insertedMovie.getId()) ).isEqualTo(newMovie);
    }  

    @Test
    public void updateMovieTest() {

        // Arrange
        Long movieId = 15L; /* GOAL CASE */
        String titulo = "Los asesinos de la luna";

        // Act
        MovieDto result = movieRepository.getReferenceById(movieId);

        // Assert
        assertNotNull(result.getId());
        assertEquals(titulo, result.getTitulo());
    }

}
