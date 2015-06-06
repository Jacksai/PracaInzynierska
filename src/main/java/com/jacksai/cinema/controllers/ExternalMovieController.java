package com.jacksai.cinema.controllers;

import com.jacksai.cinema.moviedb.MovieDbService;
import com.jacksai.cinema.moviedb.model.MovieDBMovieSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/external")
public class ExternalMovieController {

    @Autowired
    private MovieDbService movieDbService;

    @RequestMapping(value = "/{title}", method = RequestMethod.GET)
    public MovieDBMovieSearchResponse getMoviesByTitle(@PathVariable String title) {
        movieDbService.initializeGenres();
        return movieDbService.getMovieResponse(title);
    }


}
