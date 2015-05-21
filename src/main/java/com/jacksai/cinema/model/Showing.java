package com.jacksai.cinema.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "SHOWING")
public class Showing {

    @Id @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NotNull(message = "Date of showing should not be null")
    @Column(name = "SHOW_DATE")
    private Date date;

    @NotNull(message = "Hour of showing should not be null")
    @Column(name = "SHOW_HOUR")
    private Time hour;

    @JoinColumn(name = "MOVIE_ID")
    @NotNull(message = "Showing should contain movie")
    @ManyToOne(fetch = FetchType.EAGER)
    private Movie movie;

    @JoinColumn(name = "HALL_ID")
    @NotNull(message = "Showing shoud have hall")
    @ManyToOne(fetch = FetchType.EAGER)
    private Hall hall;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
