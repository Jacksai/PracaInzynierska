package com.jacksai.cinema.model;

import javax.persistence.*;
//TODO: This entity wont map to hibernate, find out why
@Entity
@Table(name = "SEAT")
public class Seat {

    @Id @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HALL_ID")
    private Hall hall;

    @Column(name = "ROW_NUMBER")
    private int rowNumber;

    @Column(name = "SEAT_NUMBER")
    private int seatNumber;

    @Column(name = "XPOSITION")
    private int xPosition;

    @Column(name = "YPOSITION")
    private int yPosition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
