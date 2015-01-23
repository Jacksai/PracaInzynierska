package com.jacksai.cinema.controllers;

import com.jacksai.cinema.model.Reservation;
import com.jacksai.cinema.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(method= RequestMethod.POST)
    public Reservation create(@RequestBody @Valid Reservation reservation) {
        return this.reservationService.save(reservation);
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<Reservation> list() {
        return this.reservationService.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Reservation get(@PathVariable long id) {
        return this.reservationService.findOne(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public Reservation update(@PathVariable("id") long id, @RequestBody @Valid Reservation reservation) {
        return reservationService.save(reservation);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
        this.reservationService.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
}
