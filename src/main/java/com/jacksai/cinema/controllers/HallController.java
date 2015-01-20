package com.jacksai.cinema.controllers;

import com.jacksai.cinema.model.Hall;
import com.jacksai.cinema.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/halls")
public class HallController {

    @Autowired
    HallService hallService;

    @RequestMapping(method = RequestMethod.POST)
    public Hall createHall(@RequestBody Hall hall) {
        return hallService.createHall(hall);
    }

}
