package com.jacksai.cinema.repository;


import com.jacksai.cinema.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
