package com.binar.chapter5.service;

import com.binar.chapter5.model.Films;
import com.binar.chapter5.model.Schedules;
import com.binar.chapter5.model.Seats;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilmsService {

    Films addFilm (Films films);

    void updateFilm (String filmName, Films films, Integer id, Schedules schedules);

    boolean deleteFilm (String filmName);

    List<Films> getFilm();

    List<Schedules> getSchedule(Integer filmCode);

    List<Seats> getStudioSeatStatus();

    Seats addSeat (Seats seats);

    void updateStatus (String seatNumber, String studioName, String statusUpdated);
}
