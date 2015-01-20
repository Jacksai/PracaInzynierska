package com.jacksai.cinema.controllers;

import com.jacksai.cinema.model.Hall;
import com.jacksai.cinema.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/api/halls")
public class HallController {

    @Autowired
    HallService hallService;

    @RequestMapping(method = RequestMethod.POST)
    public Hall createHall(@RequestBody Hall hall) {
        return hallService.createHall(hall);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Set<Hall> getAllHalls() {
        return hallService.getAllHalls();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Hall getConcreteHall(@PathVariable Long id) {
        return hallService.getHallById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Hall updateConcreteHall(@PathVariable Long id) {
        return hallService.getHallById(id);
    }

}
