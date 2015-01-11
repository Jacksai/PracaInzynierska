package com.jacksai.cinema.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String create() {
        return "hello";
    }
}
