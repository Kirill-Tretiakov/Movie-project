package com.example.maven.controller;

import com.example.maven.entity.Director;
import com.example.maven.entity.Movie;
import com.example.maven.service.IDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    @Autowired
    IDirectorService directorService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Director createDirector(@RequestBody Director director) {
        return directorService.insertDirector(director);
    }

}
