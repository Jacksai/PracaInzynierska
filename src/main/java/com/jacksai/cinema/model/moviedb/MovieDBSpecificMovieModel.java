package com.jacksai.cinema.model.moviedb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDBSpecificMovieModel {

    private Long id;

    private String original_title;

    private String overview;

    private Double vote_average;

    private List<MovieDBGenreModel> genres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public List<MovieDBGenreModel> getGenres() {
        return genres;
    }

    public void setGenres(List<MovieDBGenreModel> genres) {
        this.genres = genres;
    }
}
