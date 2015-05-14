package com.jacksai.cinema.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name = "HALL")
public class Hall {

    @Id @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    @Size(min = 3, max = 50, message = "Hall name length should be between 3 and 50 characters")
    private String name;

    @Column(name = "XLENGTH")
    @Max(value = 30, message = "Hall columns number should be lesser then 30")
    private int xLength;

    @Column(name = "YLENGTH")
    @Max(value = 30, message = "Hall rows number should be lesser then 30")
    private int yLength;

    @Column(name = "IS_ACTIVE")
    private boolean active;

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

    public int getxLength() {
        return xLength;
    }

    public void setxLength(int xLength) {
        this.xLength = xLength;
    }

    public int getyLength() {
        return yLength;
    }

    public void setyLength(int yLength) {
        this.yLength = yLength;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
