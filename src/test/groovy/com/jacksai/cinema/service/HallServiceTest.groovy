package com.jacksai.cinema.service

import com.jacksai.cinema.model.Hall
import com.jacksai.cinema.model.Seat
import com.jacksai.cinema.repository.HallRepository
import com.jacksai.cinema.repository.SeatRepository
import org.junit.runner.RunWith
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

@RunWith(Sputnik)
class HallServiceTest extends Specification {

    def hallRepository = Mock(HallRepository)
    def seatRepository = Mock(SeatRepository)
    def hallService = new HallService(hallRepository,seatRepository)
    def hall;

    def setup() {
        hall = new Hall();
        hall.id = 1;
        hall.xLength = 3;
        hall.yLength = 3;
    }

    def "should save hall by repository"() {

        when:
            hallService.createHall(hall)

        then:
            1 * hallRepository.save(_)

    }

    def "should create chairs for new hall"() {

        when:
            hallService.createHall(hall)

        then:
            9 * seatRepository.save(_)
    }

    def "should update hall by saving into repository when it has id"() {

        given:
            hallRepository.findOne(_) >> new Hall()

        when:
            hallService.updateOne(hall.id, hall)

        then:
            1 * hallRepository.save(_)

    }

    def "should not create hall when updating when it does not exist"() {

        given:
            hallRepository.findOne(_) >> null
        when:
            hallService.updateOne(23, hall)

        then:
            0 * hallRepository.save(hall)
    }

    def "should find one hall by searching in repository"() {

        when:
            hallService.findOne(21)

        then:
            1 * hallRepository.findOne(21)
    }

    def "should find all halls by searching in repository"() {

        when:
            hallService.findAll()

        then:
            1 * hallRepository.findAll()

    }

    def "should delete hall with all the chairs"() {

        given: "repository will find seat for the hall"
            def seat1  = new Seat()
            seat1.id = 2

            def seat2 = new Seat()
            seat2.id = 5

            seatRepository.findSeatsByHallId(hall.id) >> [seat1, seat2]
            hallRepository.findOne(2) >> new Hall()

        when: "hall is deleted"
            hallService.delete(hall.id)

        then: "delete all seats for hall too"
            seatRepository.delete(seat1)
            seatRepository.delete(seat2)
            hallRepository.delete(hall)

    }

    def "should do nothing when we try to delete non existing hall"() {

        given:
            hallRepository.findOne(hall.id) >> null
        when:
            hallService.delete(hall.id)
        then:
            0 * hallRepository.delete(_)
            0 * seatRepository.delete(_)
    }

}
