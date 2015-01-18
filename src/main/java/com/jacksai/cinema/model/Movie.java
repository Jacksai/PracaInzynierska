package com.jacksai.cinema.model;

import javax.persistence.*;

@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "VIEWERS_GRADE")
    private float viewersGrade;

    @Column(name = "FILMWEB_GRADE")
    private float filmwebGrade;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "LENGTH")
    private int length;

    @Column(name = "MINIMUM_AGE")
    private int minimumAge;

    @JoinColumn(name = "CATEGORY_ID")
    @ManyToOne(fetch = FetchType.EAGER)
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
