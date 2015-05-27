package com.jacksai.cinema.service;

import com.jacksai.cinema.model.SeatReservation;
import com.jacksai.cinema.repository.SeatReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SeatReservationService {

    private SeatReservationRepository seatReservationRepository;

    @Autowired
    public SeatReservationService(SeatReservationRepository seatReservationRepository) {
        this.seatReservationRepository = seatReservationRepository;
    }


    public SeatReservation save(SeatReservation seatReservation) {
        return seatReservationRepository.save(seatReservation);
    }

    public List<SeatReservation> findAll() {
        return (List<SeatReservation>) seatReservationRepository.findAll();
    }

    public SeatReservation findOne(long id) {
        return seatReservationRepository.findOne(id);
    }

    public void delete(long id) {
        seatReservationRepository.delete(id);
    }

    public boolean saveList(List<SeatReservation> listOfReservations) {
        listOfReservations
                .stream()
                .forEach(res -> seatReservationRepository.save(res));

        return true;
    }
}
