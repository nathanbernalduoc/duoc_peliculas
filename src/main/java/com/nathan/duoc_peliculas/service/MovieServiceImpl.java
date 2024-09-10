package com.nathan.duoc_peliculas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathan.duoc_peliculas.modelsDto.MessageDto;
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
        System.out.println("Buscando registro id "+id);
        return movieRepository.findById(id);
    }

    // CRUD
    @Override
    public MovieDto createMovie(MovieDto movie) {
        return movieRepository.save(movie);
    }

    @Override
    public MovieDto updateMovie(Long id, MovieDto movie) {
        if (movieRepository.existsById(id)) {
            movie.setId(id);
            return movieRepository.save(movie);
        } else {
            return null;
        }
    }

    @Override
    public MessageDto deleteMovie(Long id) {

        MessageDto message = new MessageDto("error", "Película no encontrada");
        
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            if (movieRepository.existsById(id)) {
                return new MessageDto("error", "Se ha presentado un problema al intentar eliminar la película "+Long.toString(id));
            } else {
                return new MessageDto("success", "Película eliminada ");
            }
        }

        return message;
    }
    
}
