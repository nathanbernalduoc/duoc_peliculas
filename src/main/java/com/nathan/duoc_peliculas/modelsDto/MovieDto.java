package com.nathan.duoc_peliculas.modelsDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "mov_pelicula") // tabla

public class MovieDto {

    // configuración de secuencia SEQ_PELICULA_ID
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_pelicula_id")
    @SequenceGenerator(name="seq_pelicula_id", sequenceName="seq_pelicula_id", allocationSize=1)
    @Column(name = "pelicula_id")
    private Long id;

    @Column(name = "genero_id")
    private Long genero;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "anio")
    private int anio;
    @Column(name = "director")
    private String director;
    @Column(name = "sinopsis")
    private String sinopsis;

    public MovieDto() {
    }

    public MovieDto(Long id, String titulo, int anio, String director, Long genero, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Long getGenero() {
        return genero;
    }

    public void setGenero(Long genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    

}
