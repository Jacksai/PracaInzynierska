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

    def movieRepository = Mock(MovieRepository)
    def categoryRepository = Mock(CategoryRepository)
    def movieService = new MovieService(movieRepository, categoryRepository)
    def movie
    def category

    def setup() {
        movie = new Movie()
        movie.id = 1
        category = new Category()
        category.name = "categoryName"
        movie.category = category
    }

    def "should find movie by repository"() {

        when: "request for specific movie is sent"
        movieService.find(1)

        then: "repository should look for it"
        1 * movieRepository.findOne(_)
    }

    def "should save category when it is not in repository"() {

        when: "saving movie with new category"
            movieService.save(movie)

        then: "category is saved"
            1 * categoryRepository.save(_)
            1 * movieRepository.save(_)
    }

    def "should save movie by repository"() {

        given:
            categoryRepository.findOne(_) >> category

        when: "user saves movie"
            movieService.save(movie)

        then: "movie is saved by repository"
            1 * movieRepository.save(_)

    }

    def "should delete movie without deleting category"() {

        when: "movie is deleted"
            movieService.delete(movie.id)

        then: "category is not deleted"
         1 * movieRepository.delete(_)
         0 * categoryRepository.delete(_)
    }

    def "should find all movies from repository"() {

        when:
            movieService.findAll()

        then:
            1 * movieRepository.findAll()
    }

}
