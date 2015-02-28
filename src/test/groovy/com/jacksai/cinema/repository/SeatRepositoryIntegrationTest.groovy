package com.jacksai.cinema.repository

import com.jacksai.cinema.Application
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = Application.class)
@ActiveProfiles(profiles = "test")
@WebAppConfiguration
@IntegrationTest
class SeatRepositoryIntegrationTest extends Specification {

    @Autowired
    SeatRepository seatRepository

    def "should find seats by hall id"(long a, long b) {

        expect:
        seatRepository.findSeatsByHallId(a).size() == b

        where:
        a | b
        1 | 4
        2 | 12
    }
}
