package com.jacksai.cinema.moviedb.model;

import java.util.List;

public class MovieDBGenreListResponse {

    private List<MovieDBGenreModel> genres;

    public List<MovieDBGenreModel> getGenres() {
        return genres;
    }

    public void setGenres(List<MovieDBGenreModel> genres) {
        this.genres = genres;
    }
}
