package com.jacksai.cinema.repository;

import com.jacksai.cinema.model.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat, Long> {
}
