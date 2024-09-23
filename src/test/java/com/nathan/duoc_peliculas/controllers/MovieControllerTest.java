package com.nathan.duoc_peliculas.controllers;

import static org.mockito.Mockito.when;

import java.util.List;

import java.util.Arrays;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.nathan.duoc_peliculas.modelsDto.MovieDto;
import com.nathan.duoc_peliculas.service.MovieServiceImpl;

@WebMvcTest(MovieController.class)
public class MovieControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieServiceImpl movieServiceImpl;

    @Test
    public void getAllTestHatoaes() throws Exception {
        //Arrange
        // Movies creation
        MovieDto movie1 = new MovieDto();
        movie1.setTitulo("Testing new pelicula #99");
        movie1.setId(76L);
        movie1.setAnio(1980);

        MovieDto movie2 = new MovieDto();
        movie2.setTitulo("Testing new pelicula #100");
        movie2.setId(30L);
        movie2.setAnio(2014);

        List<MovieDto> movies = Arrays.asList(movie1, movie2);

        when(movieServiceImpl.getAllMovie()). thenReturn(movies);

        // Act && Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/peliculas"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.aMapWithSize(2)))
            .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.movieDtoList[0].titulo", Matchers.is("Testing new pelicula #99")))
            .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.movieDtoList[1].titulo", Matchers.is("Testing new pelicula #100")));
    }

    @Test
    public void getMovieIdTest() throws Exception {
        //Arrange
        // Movies creation
        //String titulo = "Oppenheimer";

        // Act && Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/peliculas", "23"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.aMapWithSize(1)));

    }

}
