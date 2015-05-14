package com.jacksai.cinema.controllers;

import com.jacksai.cinema.model.Category;
import com.jacksai.cinema.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method= RequestMethod.POST)
    public Category create(@RequestBody @Valid Category category) {
        return this.categoryService.save(category);
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<Category> list() {
        return this.categoryService.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Category get(@PathVariable long id) {
        return this.categoryService.findOne(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public Category update(@PathVariable long id, @RequestBody @Valid Category category) {
        return categoryService.save(category);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
        Category category = categoryService.findOne(id);
        this.categoryService.delete(category);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
}
