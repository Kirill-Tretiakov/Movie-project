package com.example.maven.repository;

import com.example.maven.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository  extends JpaRepository<Director, Integer> {
}
