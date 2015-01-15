package com.jacksai.cinema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hall {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int xLength;
    private int yLength;
    private boolean active;
}
