package com.jacksai.cinema.controllers;

import com.jacksai.cinema.model.Showing;
import com.jacksai.cinema.service.ShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/showings")
public class ShowingController {

    private ShowingService showingService;

    @Autowired
    public ShowingController(ShowingService showingService) {
        this.showingService = showingService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Showing create(@RequestBody @Valid Showing showing) {
        return showingService.save(showing);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Showing> list() {
        return showingService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Showing get(@PathVariable Long id) {
        return showingService.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Showing update(@PathVariable Long id, @RequestBody @Valid Showing showing) {
        return showingService.update(id, showing);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        showingService.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);

    }

}
