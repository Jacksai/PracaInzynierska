package com.jacksai.cinema.controllers;

import com.jacksai.cinema.model.Movie;
import com.jacksai.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Movie create(@RequestBody @Valid Movie movie) {
        return movieService.save(movie);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Movie> list() {
        return movieService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Movie get(@PathVariable Long id) {
        return movieService.find(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Movie update(@PathVariable Long id, @RequestBody @Valid Movie movie) {
        return movieService.save(movie);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        movieService.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}
