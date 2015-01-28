package com.jacksai.cinema.service;

import com.jacksai.cinema.model.Category;
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
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie save(Movie movie) {

        Category cat = categoryRepository.findOne(movie.getCategory().getId());

        if(cat == null) {
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
