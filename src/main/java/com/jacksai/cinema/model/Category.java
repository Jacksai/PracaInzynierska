package com.jacksai.cinema.model;

import javax.persistence.*;
import javax.validation.Constraint;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
