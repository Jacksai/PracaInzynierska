package com.jacksai.cinema.model.moviedb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDBMovieSearchResponse {

    private Long page;

    private List<MovieDBMovieModel> results;

    private Long total_pages;

    private Long total_results;


    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public List<MovieDBMovieModel> getResults() {
        return results;
    }

    public void setResults(List<MovieDBMovieModel> results) {
        this.results = results;
    }

    public Long getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Long total_pages) {
        this.total_pages = total_pages;
    }

    public Long getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Long total_results) {
        this.total_results = total_results;
    }
}
