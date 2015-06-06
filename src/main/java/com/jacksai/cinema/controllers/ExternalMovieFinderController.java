package com.jacksai.cinema.controllers;

import com.jacksai.cinema.moviedb.MovieDbService;
import com.jacksai.cinema.moviedb.model.MovieDBMovieSearchResponse;
import com.jacksai.cinema.moviedb.model.MovieDBSpecificMovieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Boolean> saveExternalMovieIntoDatabase(@RequestBody MovieDBSpecificMovieModel movieModel) {
        return new ResponseEntity<Boolean>( movieDbService.saveMovie(movieModel), HttpStatus.OK);
    }



}
