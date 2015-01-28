package com.jacksai.cinema.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    @NotNull(message = "Description should not be empty")
    private String description;

    @Column(name = "VIEWERS_GRADE")
    @Max(value = 10)
    private float viewersGrade;

    @Column(name = "FILMWEB_GRADE")
    @Max(value = 10)
    private float filmwebGrade;

    @Column(name = "TITLE")
    @NotNull(message = "Movie title should not be null")
    private String title;

    @Column(name = "LENGTH")
    @NotNull(message = "Movie length not specified")
    @Max(value = 500, message = "Movie should not be longer then 500 minutes")
    @Min(value = 30, message = "Movie should not be shorter then 30 minutes")
    private int length;

    @Column(name = "MINIMUM_AGE")
    @Max(value = 25, message = "Minimum age must be lesser then 21")
    private int minimumAge;

    @JoinColumn(name = "CATEGORY_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull(message = "Movie should contain a Category")
    private Category category;

    @Column(name = "IS_ACTIVE")
    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getViewersGrade() {
        return viewersGrade;
    }

    public void setViewersGrade(float viewersGrade) {
        this.viewersGrade = viewersGrade;
    }

    public float getFilmwebGrade() {
        return filmwebGrade;
    }

    public void setFilmwebGrade(float filmwebGrade) {
        this.filmwebGrade = filmwebGrade;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
