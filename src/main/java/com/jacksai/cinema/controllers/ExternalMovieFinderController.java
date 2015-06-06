package com.jacksai.cinema.controllers;

import com.jacksai.cinema.moviedb.MovieDbService;
import com.jacksai.cinema.moviedb.model.MovieDBMovieSearchResponse;
import com.jacksai.cinema.moviedb.model.MovieDBSpecificMovieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/externalMovieFinder")
public class ExternalMovieFinderController {

    @Autowired
    private MovieDbService movieDbService;

    @RequestMapping(value = "/{title}", method = RequestMethod.GET)
    public MovieDBMovieSearchResponse getMoviesByTitle(@PathVariable String title) {
        return movieDbService.getMovieResponse(title);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public MovieDBSpecificMovieModel getMovieDetails(@PathVariable Long id) {
        return movieDbService.getMovieDetails(id);
    }



}
