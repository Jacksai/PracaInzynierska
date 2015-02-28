package com.jacksai.cinema.controllers

import com.jacksai.cinema.model.Movie
import com.jacksai.cinema.service.MovieService
import spock.lang.Shared
import spock.lang.Specification

class MovieControllerTest extends Specification {

    def movieService = Mock(MovieService)
    def movieController = new MovieController(movieService)
    @Shared def correctMovie

    def setupSpec() {
        correctMovie = new Movie();
    }

    def "should not accept empty movie"() {
        when:
            movieController.create(correctMovie)
        then:
            1 * movieService.save(_)
    }

}
