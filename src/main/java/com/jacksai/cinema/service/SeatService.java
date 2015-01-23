package com.jacksai.cinema.service;

import com.jacksai.cinema.model.Seat;
import com.jacksai.cinema.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SeatService {

    private SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Seat save(Seat seat) {
        return seatRepository.save(seat);
    }

    public List<Seat> findAll() {
        return (List<Seat>) seatRepository.findAll();
    }

    public Seat findOne(long id) {
        return seatRepository.findOne(id);
    }

    public void delete(long id) {
        seatRepository.delete(id);
    }
}
