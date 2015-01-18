package com.jacksai.cinema.repository;

import com.jacksai.cinema.model.Showing;
import org.springframework.data.repository.CrudRepository;

public interface ShowRepository extends CrudRepository<Showing, Long> {
}
