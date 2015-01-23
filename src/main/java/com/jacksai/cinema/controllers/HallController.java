package com.jacksai.cinema.controllers;

import com.jacksai.cinema.model.Hall;
import com.jacksai.cinema.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/halls")
public class HallController {

    @Autowired
    HallService hallService;

    @RequestMapping(method = RequestMethod.POST)
    public Hall create(@RequestBody Hall hall) {
        return hallService.createHall(hall);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Set<Hall> list() {
        return hallService.getAllHalls();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Hall get(@PathVariable Long id) {
        return hallService.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Hall update(@PathVariable Long id, @RequestBody @Valid Hall hall) {
        return hallService.updateOne(id, hall);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        hallService.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}
