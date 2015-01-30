package com.jacksai.cinema.service

import com.jacksai.cinema.model.Category
import com.jacksai.cinema.model.Movie
import com.jacksai.cinema.repository.CategoryRepository
import com.jacksai.cinema.repository.MovieRepository
import org.junit.runner.RunWith
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

@RunWith(Sputnik)
class MovieServiceTest extends Specification {

    MovieRepository movieRepository = Mock()
    def categoryRepository = Mock(CategoryRepository){
        findOne(2) >> null
        findOne(3) >> new Category()
    }

    MovieService movieService

    def setup() {
        movieService = new MovieService(movieRepository, categoryRepository)
    }

    def "should forward finding movie to repository"() {

        when: "request for specific movie is sent"
        movieService.find(12)

        then: "repository should look for it"
        1 * movieRepository.findOne(_)

    }

    def "should save category when it does not exist"() {

        given:
            def movie = new Movie()
            def category = new Category()
            category.name = "NEW CATEGORY"
            movie.category = category

        when: "saving movie with new category"
            movieService.save(movie)

        then: "category is saved"
            1 * categoryRepository.save(_)
            1 * movieRepository.save(_)
    }

    def "should save movie by repository"() {

        given:
            def movie = new Movie()
            def category = new Category()
            category.id = 3
            movie.category = category

        when: "user saves movie"
            movieService.save(movie)

        then: "movie is saved by repository"
            1 * movieRepository.save(_)

    }

    def "movie is deleted without deleting category"() {

        given:
            def movie = new Movie()
            movie.id = 0

        when: "movie is deleted"
            movieService.delete(movie.id)

        then: "category is not deleted"
         1 * movieRepository.delete(_)
         0 * categoryRepository.delete(_)
    }

    def "MovieService should find all movies"() {
        when:
            movieService.findAll()
        then:
            1 * movieRepository.findAll()
    }

}
