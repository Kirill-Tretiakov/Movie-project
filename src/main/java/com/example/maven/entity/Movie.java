package com.example.maven.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @Positive
    private int duration;

    @ManyToOne(targetEntity = Director.class, optional = false, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Director director;
}
