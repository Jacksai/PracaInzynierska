package com.jacksai.cinema.service

import com.jacksai.cinema.repository.MovieRepository
import org.junit.runner.RunWith
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

@RunWith(Sputnik)
class MovieServiceTest extends Specification {

    MovieRepository repo = Mock()
    def movieService

    def setup() {
        movieService = new MovieService(repo)
    }

    def "should forward finding movie to repository"() {

        when: "request for specific movie is sent"
        movieService.find(12)

        then: "repository should look for it"
        1 * repo.findOne(_)

    }

}
