package com.jacksai.cinema.repository;


import com.jacksai.cinema.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
