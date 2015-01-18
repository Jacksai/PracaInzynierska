package com.jacksai.cinema.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "SHOW")
public class Show {
    @Id @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "SHOW_DATE")
    private Date date;

    @Column(name = "SHOW_HOUR")
    private Time hour;

    @JoinColumn(name = "MOVIE_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Movie movie;

    @JoinColumn(name = "HALL_ID")
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
