package com.jacksai.cinema.service;

import com.jacksai.cinema.model.Hall;
import com.jacksai.cinema.model.Seat;
import com.jacksai.cinema.repository.HallRepository;
import com.jacksai.cinema.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class HallService {

    private HallRepository hallRepository;

    private SeatRepository seatRepository;

    @Autowired
    public HallService(HallRepository hallRepository, SeatRepository seatRepository) {
        this.hallRepository = hallRepository;
        this.seatRepository = seatRepository;
    }

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

    public Set<Hall> findAll() {
        return (Set<Hall>) hallRepository.findAll();
    }

    public Hall findOne(Long id) {
        return hallRepository.findOne(id);
    }

    public Hall updateOne(Long id, Hall hall) {

        if(hallRepository.findOne(id) != null) {
            return hallRepository.save(hall);
        } else {
            return null;
        }

    }

    public void delete(Long id) {

        Hall hall = hallRepository.findOne(id);

        if(hall != null) {
            List<Seat> seats = seatRepository.findSeatsByHallId(id);

            for(Seat seat : seats)
                seatRepository.delete(seat);

            hallRepository.delete(hall);
        }

    }

}
