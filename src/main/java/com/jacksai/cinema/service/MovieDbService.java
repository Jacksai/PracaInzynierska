package com.jacksai.cinema.service;

import com.jacksai.cinema.model.Category;
import com.jacksai.cinema.model.Movie;
import com.jacksai.cinema.model.moviedb.MovieDBGenreListResponse;
import com.jacksai.cinema.model.moviedb.MovieDBGenreModel;
import com.jacksai.cinema.model.moviedb.MovieDBMovieSearchResponse;
import com.jacksai.cinema.model.moviedb.MovieDBSpecificMovieModel;
import com.jacksai.cinema.repository.CategoryRepository;
import com.jacksai.cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

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

    public MovieDBSpecificMovieModel getMovieDetails(Long id) {

        RestTemplate restTemplate = new RestTemplate();

        MovieDBSpecificMovieModel movie = restTemplate.getForObject(API_URL + "/movie/" + id.toString() + URL_ENDING_WITHOUT_QUERY, MovieDBSpecificMovieModel.class);

        return movie;
    }

    public Boolean saveMovie(MovieDBSpecificMovieModel movieModel) {
        Movie localModel = new Movie();

        localModel.setTitle(movieModel.getOriginal_title());
        localModel.setActive(true);

        //Finding category to save
        Optional<MovieDBGenreModel> categoryOptional = movieModel.getGenres().stream().filter((cat) -> categoryRepository.findByName(cat.getName()) != null).findFirst();

        if(categoryOptional.isPresent()) {
            Category category = categoryRepository.findByName(categoryOptional.get().getName());
            localModel.setCategory(category);
        } else {
            //Save first category to repo and save it
            Category category = new Category();
            Optional<MovieDBGenreModel> genre = movieModel.getGenres().stream().findFirst();

            if(genre.isPresent()) {
                category.setName(genre.get().getName());
            } else {
                return false;
            }

            categoryRepository.save(category);
            localModel.setCategory(category);
        }

        localModel.setDescription(movieModel.getOverview().substring(0, 255));
        localModel.setFilmwebGrade(movieModel.getVote_average().floatValue());
        localModel.setViewersGrade(movieModel.getVote_average().floatValue());
        localModel.setLength(120);


        movieRepository.save(localModel);
        return true;

    }

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
