package com.jacksai.cinema.service;

import com.jacksai.cinema.model.Reservation;
import com.jacksai.cinema.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReservationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> findAll() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    public Reservation findOne(long id) {
        return reservationRepository.findOne(id);
    }

    public void delete(long id) {
        reservationRepository.delete(id);
    }
}
