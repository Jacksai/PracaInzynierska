package com.jacksai.cinema.repository;

import com.jacksai.cinema.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
