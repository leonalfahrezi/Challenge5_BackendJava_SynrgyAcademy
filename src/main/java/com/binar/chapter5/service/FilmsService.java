package com.binar.chapter5.service;

import com.binar.chapter5.model.Films;
import com.binar.chapter5.model.Schedules;
import com.binar.chapter5.model.Seats;
import com.binar.chapter5.model.SeatsId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilmsService {

    Films addFilm (Films films);

    void updateFilm (Films films);

    boolean deleteFilm (String filmName);

    Films getFilm();

    Schedules addSchedule (Schedules schedules);

    Schedules getScheduleDate();

    Seats getSeatStudio();

    public List<Seats> getStudioSeatStatus();

    void updateStatus (String seatNumber, String studioName, String statusUpdated);
}
