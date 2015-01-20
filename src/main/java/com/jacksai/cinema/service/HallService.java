package com.jacksai.cinema.service;

import com.jacksai.cinema.model.Hall;
import com.jacksai.cinema.model.Seat;
import com.jacksai.cinema.repository.HallRepository;
import com.jacksai.cinema.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class HallService {

    @Autowired
    HallRepository hallRepository;

    @Autowired
    SeatRepository seatRepository;

    @Transactional
    public Hall createHall(Hall hall) {

        Hall saved =  hallRepository.save(hall);

        for (int i = 0; i < hall.getxLength(); i++) {
            for (int j = 0; j < hall.getyLength() ; j++) {
                Seat seat = new Seat();
                seat.setxPosition(i);
                seat.setyPosition(j);
                seat.setRowNumber(j + 1);
                seat.setSeatNumber(i + 1);
                seat.setHall(hall);

                seatRepository.save(seat);
            }
        }
        return saved;
    }


}
