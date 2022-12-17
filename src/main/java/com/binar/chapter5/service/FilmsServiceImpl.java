package com.binar.chapter5.service;

import com.binar.chapter5.model.Films;
import com.binar.chapter5.model.Schedules;
import com.binar.chapter5.model.Seats;
import com.binar.chapter5.model.SeatsId;
import com.binar.chapter5.repository.FilmsRepository;
import com.binar.chapter5.repository.SchedulesRepository;
import com.binar.chapter5.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmsServiceImpl implements FilmsService {

    @Autowired
    FilmsRepository filmsRepository;
    @Autowired
    SchedulesRepository schedulesRepository;
    @Autowired
    SeatsRepository seatsRepository;

    @Override
    public Films addFilm(Films films) {

        Optional<Films> filmAdd = filmsRepository.findById(films.getFilmName());
        if (filmAdd.isPresent()) {
            System.out.println("Films has been registered before, try another!");
        }
        return filmsRepository.save(films);
    }

    @Override
    public void updateFilm(Films films) {
        Optional<Films> filmUpdate = filmsRepository.findById(films.getFilmName());
        if (!filmUpdate.isPresent()) {
            filmUpdate.get().setFilmCode(films.getFilmCode());
            filmUpdate.get().setFilmName(films.getFilmName());
            filmUpdate.get().setPlaying(films.isPlaying());
            filmsRepository.save(films);
        } else
            System.out.println("Films has been registered before, try another!");
    }

    @Override
    public boolean deleteFilm(String filmName) {

        Optional<Films> filmDelete = filmsRepository.findById(filmName);
        filmsRepository.deleteById(filmName);

        if (!filmDelete.isPresent()) {
            System.out.println("Films has been deleted!");
        }
        return true;
    }

    @Override
    public Films getFilm() {
        return filmsRepository.getFilmsByName();
    }


    @Override
    public Schedules addSchedule(Schedules schedules) {
        Optional<Schedules> scheduleAdd = schedulesRepository.findById(schedules.getScheduleId());
        if (scheduleAdd.isPresent()) {
            System.out.println("Schedule has been registered before, try another!");
        }
        return schedulesRepository.save(schedules);
    }

    @Override
    public Schedules getScheduleDate() {
        return schedulesRepository.getSchedulesDate();
    }

    @Override
    public Seats getSeatStudio() {
        return seatsRepository.getSeatStudio();
    }

    @Override
    public List<Seats> getStudioSeatStatus() {
        return seatsRepository.getStudioSeatStatus();
    }

    @Override
    public void updateStatus(String seatNumber, String studioName, String statusUpdated) {
        seatsRepository.updateStatus(seatNumber, studioName, statusUpdated);
    }
}
