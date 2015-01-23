package com.jacksai.cinema.service;

import com.jacksai.cinema.repository.UserRepository;
import com.jacksai.cinema.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public User findOne(long id) {
        return userRepository.findOne(id);
    }

    public void delete(long id) {
        userRepository.delete(id);
    }
}
