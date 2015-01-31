package com.jacksai.cinema.repository;

import com.jacksai.cinema.model.Seat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeatRepository extends CrudRepository<Seat, Long> {

    List<Seat> findSeatsByHallId(Long hallId);

}
