package com.example.maven.service;

import com.example.maven.entity.Director;
import com.example.maven.entity.Movie;

import java.util.List;

public interface IDirectorService {

    List<Director> getAllDirectors();

    Director insertDirector(Director director);
}
