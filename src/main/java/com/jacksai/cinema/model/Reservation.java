package com.jacksai.cinema.model;

import com.jacksai.cinema.model.Enums.ReservationState;

public class Reservation {

    private Long id;
    private int seatCount;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private ReservationState reservationState;
    private Show show;
    private boolean finalized;

}
