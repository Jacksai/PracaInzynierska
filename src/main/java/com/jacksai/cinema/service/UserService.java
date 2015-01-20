package com.jacksai.cinema.service;

import com.jacksai.cinema.repository.UserRepository;
import com.jacksai.cinema.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }


}
