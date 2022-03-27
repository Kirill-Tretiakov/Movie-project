package com.example.maven.service;

import com.example.maven.entity.Director;
import com.example.maven.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService implements IDirectorService {
    @Autowired
    DirectorRepository directorRepository;

    @Override
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    @Override
    public Director insertDirector(Director director) {
        return directorRepository.save(director);
    }
}
