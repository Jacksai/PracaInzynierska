package com.jacksai.cinema.moviedb;

import com.jacksai.cinema.model.Category;
import com.jacksai.cinema.model.Movie;
import com.jacksai.cinema.moviedb.model.MovieDBGenreListResponse;
import com.jacksai.cinema.moviedb.model.MovieDBMovieModel;
import com.jacksai.cinema.moviedb.model.MovieDBMovieSearchResponse;
import com.jacksai.cinema.repository.CategoryRepository;
import com.jacksai.cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieDbService {

    private static String API_KEY = "0e59b1dfd03d2bc7a2727a9120cc88a5";

    private static String API_URL = "http://api.themoviedb.org/3/";

    private static String URL_ENDING_AFTER_QUERY = "&api_key=" + API_KEY;
    private static String URL_ENDING_WITHOUT_QUERY = "?api_key=" + API_KEY;


    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public MovieDBMovieSearchResponse getMovieResponse(String title) {
        RestTemplate restTemplate = new RestTemplate();

        MovieDBMovieSearchResponse movieDBMovieSearchResponse = restTemplate.getForObject(API_URL + "/search/movie?query=" + title + URL_ENDING_AFTER_QUERY, MovieDBMovieSearchResponse.class);
        return movieDBMovieSearchResponse;
    }

    public void initializeGenres() {

        RestTemplate restTemplate = new RestTemplate();

        MovieDBGenreListResponse genreList = restTemplate.getForObject(API_URL + "/genre/movie/list" + URL_ENDING_WITHOUT_QUERY, MovieDBGenreListResponse.class);

        genreList.getGenres().stream().forEach((g) -> {
            Category cat = new Category();
            cat.setId(g.getId());
            cat.setName(g.getName());

            if(categoryRepository.findOne(cat.getId()) == null)
                categoryRepository.save(cat);

        });

    }

    publi
//
//    public boolean saveMovieToLocalDatabase (MovieDBMovieModel movie) {
//
//        Movie movieModel = new Movie();
//        movieModel.setDescription(movie.getOverview());
//        movieModel.setTitle(movie.getTitle());
//        movieModel.setFilmwebGrade(movie.getVote_average());
//        movieModel.setViewersGrade(movie.getVote_average());
//
//
//
//    }

}
