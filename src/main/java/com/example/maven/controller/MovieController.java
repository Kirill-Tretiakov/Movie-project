package com.example.maven.controller;

import com.example.maven.dto.MovieDTO;
import com.example.maven.entity.Movie;
import com.example.maven.service.IMovieService;
import com.example.maven.validation.MovieValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    IMovieService movieService;

    @Autowired
    MovieValidator movieValidator;

    @RequestMapping(method = RequestMethod.GET)
    public MovieDTO getMovies(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "3") int size,
                              HttpServletRequest request,
                              Principal principal) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return movieService.getMovies(pageRequest);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{directorId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie createMovie(@RequestBody @Valid Movie movie, @PathVariable Integer directorId) {
        return movieService.insertMovie(movie, directorId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable Integer id) {
        movie.setId(id);
        movieService.updateMovie(movie);
        return movie;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
    }

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(movieValidator);
    }
}
