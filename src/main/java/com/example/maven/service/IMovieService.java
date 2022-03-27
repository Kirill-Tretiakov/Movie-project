package com.example.maven.service;

import com.example.maven.dto.MovieDTO;
import com.example.maven.entity.Movie;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IMovieService {

    void deleteMovie(Integer id);

    MovieDTO getMovies(PageRequest pageRequest);

    Movie updateMovie(Movie movie);

    Movie insertMovie(Movie movie, int directorId);

}
