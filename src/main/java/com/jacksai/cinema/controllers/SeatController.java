package com.jacksai.cinema.controllers;

import com.jacksai.cinema.model.Seat;
import com.jacksai.cinema.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @RequestMapping(method= RequestMethod.POST)
    public Seat create(@RequestBody @Valid Seat seat) {
        return this.seatService.save(seat);
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<Seat> list() {
        return this.seatService.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Seat get(@PathVariable long id) {
        return this.seatService.findOne(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public Seat update(@PathVariable long id, @RequestBody @Valid Seat seat) {
        return seatService.save(seat);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        this.seatService.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
}
