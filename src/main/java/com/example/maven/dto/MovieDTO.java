package com.example.maven.dto;

import com.example.maven.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private List<Movie> movies;
    private int totalElements;
    private int pagesCount;
    private boolean isLast;
    private boolean isEmpty;
}
