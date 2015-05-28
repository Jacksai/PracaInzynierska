package com.jacksai.cinema.repository;

import com.jacksai.cinema.model.SeatReservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeatReservationRepository extends CrudRepository<SeatReservation, Long> {

    List<SeatReservation> findSeatReservationsByShowId(Long showId);

}
