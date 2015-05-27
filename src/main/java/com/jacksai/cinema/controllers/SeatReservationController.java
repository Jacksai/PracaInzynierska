package com.jacksai.cinema.controllers;

import com.jacksai.cinema.model.SeatReservation;
import com.jacksai.cinema.service.SeatReservationService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/seatReservations")
public class SeatReservationController {

    private SeatReservationService seatReservationService;

    @Autowired
    public SeatReservationController(SeatReservationService seatReservationService) {
        this.seatReservationService = seatReservationService;
    }

    @RequestMapping(method= RequestMethod.POST)
    public SeatReservation create(@RequestBody @Valid SeatReservation seatReservation) {
        return this.seatReservationService.save(seatReservation);
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<SeatReservation> list() {
        return this.seatReservationService.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public SeatReservation get(@PathVariable("id") long id) {
        return this.seatReservationService.findOne(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseEntity<Boolean> reserveList(@RequestBody List<SeatReservation> listOfReservations) {
        boolean status =  seatReservationService.saveList(listOfReservations);
        return new ResponseEntity<Boolean>(status, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public SeatReservation update(@PathVariable("id") long id, @RequestBody @Valid SeatReservation seatReservation) {
        return seatReservationService.save(seatReservation);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
        this.seatReservationService.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
}
