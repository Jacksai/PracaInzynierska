package com.jacksai.cinema.controllers;

import com.jacksai.cinema.model.User;
import com.jacksai.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public User saveUser() {
        User user = new User();
        user.setName("Tomasz");
        user.setSurname("Bawor");
        return userService.saveUser(user);
    }

}
