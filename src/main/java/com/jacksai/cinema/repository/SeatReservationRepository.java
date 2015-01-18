package com.jacksai.cinema.repository;

import com.jacksai.cinema.model.SeatReservation;
import org.springframework.data.repository.CrudRepository;

public interface SeatReservationRepository extends CrudRepository<SeatReservation, Long> {
}
