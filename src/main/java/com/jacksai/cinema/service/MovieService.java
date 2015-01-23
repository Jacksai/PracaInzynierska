package com.jacksai.cinema.service;

import com.jacksai.cinema.model.Movie;
import com.jacksai.cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> findAll() {
        return (List<Movie>) movieRepository.findAll();
    }

    public Movie find(Long id) {
        return movieRepository.findOne(id);
    }

    public void delete(Long id) {
        movieRepository.delete(id);
    }
}
