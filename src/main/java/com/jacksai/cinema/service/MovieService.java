package com.jacksai.cinema.service;

import com.jacksai.cinema.model.Movie;
import com.jacksai.cinema.repository.CategoryRepository;
import com.jacksai.cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, CategoryRepository categoryRepository) {
        this.movieRepository = movieRepository;
        this.categoryRepository = categoryRepository;
    }

    public Movie save(Movie movie) {

        if(movie.getCategory().getId() == null) {
            categoryRepository.save(movie.getCategory());
        }
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
