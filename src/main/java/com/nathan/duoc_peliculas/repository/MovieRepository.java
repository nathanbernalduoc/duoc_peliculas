package com.nathan.duoc_peliculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nathan.duoc_peliculas.modelsDto.MovieDto;

public interface MovieRepository extends JpaRepository<MovieDto, Long> {

}
