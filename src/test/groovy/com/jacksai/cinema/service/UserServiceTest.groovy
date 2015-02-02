package com.jacksai.cinema.service

import com.jacksai.cinema.model.User
import com.jacksai.cinema.repository.UserRepository
import org.junit.runner.RunWith
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

@RunWith(Sputnik)
class UserServiceTest extends Specification {

    def userRepository = Mock(UserRepository)
    def userService = new UserService(userRepository)

    def "should save user by repository"() {

        given:
            def user = new User()

        when:
            userService.save(user)

        then:
            1  * userRepository.save(_)

    }

    def "should find user by id using repository"() {

        when:
            userService.findOne(1)

        then:
            1 * userRepository.findOne(1)
    }

    def "should get all users from repository" () {

        when:
            userService.findAll()

        then:
            1 * userRepository.findAll()

    }

    def "should delete user from repository"() {

        when:
            userService.delete(1);

        then:
            userRepository.delete(1)

    }
}
