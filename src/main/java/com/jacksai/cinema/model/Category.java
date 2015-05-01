package com.jacksai.cinema.model;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "CATEGORY_NAME", unique = true)
    @NotNull(message = "Category name should not be null")
    @Size(min = 3, max = 20, message = "Category name should be between 3 and 20 character")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
