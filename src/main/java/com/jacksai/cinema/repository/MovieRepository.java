package com.jacksai.cinema.repository;

import com.jacksai.cinema.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
