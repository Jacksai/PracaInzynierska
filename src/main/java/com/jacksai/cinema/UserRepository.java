package com.jacksai.cinema;


import com.jacksai.cinema.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
