package com.jacksai.cinema.service;

import com.jacksai.cinema.model.Seat;
import com.jacksai.cinema.model.SeatReservation;
import com.jacksai.cinema.model.Showing;
import com.jacksai.cinema.repository.SeatRepository;
import com.jacksai.cinema.repository.SeatReservationRepository;
import com.jacksai.cinema.repository.ShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowingService {

    private ShowingRepository showingRepository;

    private SeatReservationRepository seatReservationRepository;

    private SeatRepository seatRepository;

    @Autowired
    public ShowingService(ShowingRepository showingRepository, SeatRepository seatRepository, SeatReservationRepository seatReservationRepository) {
        this.showingRepository = showingRepository;
        this.seatReservationRepository = seatReservationRepository;
        this.seatRepository = seatRepository;
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

    public List<Seat> getFreeSeatsForShowing(Long showId) {

        Showing showing = showingRepository.findOne(showId);

        List<Seat> seatsInHall = seatRepository.findSeatsByHallId(showing.getHall().getId());

        List<Seat> reservedSeats = seatReservationRepository.findSeatReservationsByShowId(showId)
                .stream()
                .map(SeatReservation::getSeat)
                .collect(Collectors.toList());

        if(reservedSeats.isEmpty()) {
            return seatsInHall;
        } else {
            return seatsInHall.stream().filter(s -> !reservedSeats.contains(s)).collect(Collectors.toList());
        }



    }
}
