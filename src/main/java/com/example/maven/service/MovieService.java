package com.example.maven.service;

import com.example.maven.dto.MovieDTO;
import com.example.maven.entity.Movie;
import com.example.maven.repository.DirectorRepository;
import com.example.maven.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
public class MovieService implements IMovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public MovieDTO getMovies(PageRequest pageRequest) {
        Page<Movie> moviePage = movieRepository.findAll(pageRequest);
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setTotalElements(moviePage.getTotalPages());
        movieDTO.setMovies(moviePage.getContent());
        movieDTO.setEmpty(moviePage.isEmpty());
        movieDTO.setLast(moviePage.isLast());
        movieDTO.setPagesCount(moviePage.getTotalPages());
        movieDTO.setTotalElements(moviePage.getTotalPages());
        return movieDTO;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie insertMovie(Movie movie, int directorId) {
        if (movieRepository.findByTitle(movie.getTitle()).isPresent()) {
            log.info("Movie with title " + movie.getTitle() + " exists in database");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This movie title already exists!");
        }
        directorRepository.findById(directorId).ifPresent(director -> {
            movie.setDirector(director);
            movieRepository.save(movie);
        });
        return movie;
    }
}
