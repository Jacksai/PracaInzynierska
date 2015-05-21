package com.jacksai.cinema.service;

import com.jacksai.cinema.model.Showing;
import com.jacksai.cinema.repository.ShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowingService {

    private ShowingRepository showingRepository;

    @Autowired
    public ShowingService(ShowingRepository showingRepository) {
        this.showingRepository = showingRepository;
    }

    public Showing save(Showing showing) {
        return showingRepository.save(showing);
    }

    public List<Showing> findAll() {
        return (List<Showing>) showingRepository.findAll();
    }

    public Showing findOne(Long id) {
        return showingRepository.findOne(id);
    }

    public Showing update(Long id, Showing showing) {
        return showingRepository.save(showing);
    }

    public void delete(Long id) {
        //TODO: IMPLEMENT THIS SHIT
         showingRepository.delete(id);    }
}
