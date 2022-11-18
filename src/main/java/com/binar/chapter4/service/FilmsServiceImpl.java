package com.binar.chapter4.service;

import com.binar.chapter4.model.Films;
import com.binar.chapter4.model.Schedules;
import com.binar.chapter4.model.Seats;
import com.binar.chapter4.repository.FilmsRepository;
import com.binar.chapter4.repository.SchedulesRepository;
import com.binar.chapter4.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmsServiceImpl implements FilmsService {

    @Autowired
    FilmsRepository filmsRepository;
    SchedulesRepository schedulesRepository;
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
    public void updateFilm(String filmName, Films films, Integer id, Schedules schedules) {

        Optional<Films> filmUpdate = filmsRepository.findById(films.getFilmName());
        filmUpdate.get().setFilmCode(films.getFilmCode());
        filmUpdate.get().setFilmName(films.getFilmName());
        filmUpdate.get().setPlaying(films.isPlaying());
        filmsRepository.save(films);

        Optional<Schedules> scheduleUpdate = schedulesRepository.findById(schedules.getScheduleId());
        scheduleUpdate.get().setScheduleId(schedules.getScheduleId());
        scheduleUpdate.get().setFilmCode(schedules.getFilmCode());
        scheduleUpdate.get().setPlayingDate(schedules.getPlayingDate());
        scheduleUpdate.get().setStartingTime(schedules.getStartingTime());
        scheduleUpdate.get().setEndingTime(schedules.getEndingTime());
        scheduleUpdate.get().setTicketPrice(schedules.getTicketPrice());
        schedulesRepository.save(schedules);

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
    public List<Films> getFilm() {

        return filmsRepository.getAllFilms();
    }

    @Override
    public List<Schedules> getSchedule(Integer filmCode) {

        List<Schedules> getScheduleByFilmCode = schedulesRepository.getSchedules();
        return getScheduleByFilmCode;
    }

    @Override
    public List<Seats> getStudioSeatStatus() {
        return seatsRepository.getStudioSeatStatus();
    }

    @Override
    public Seats addSeat(Seats seats) {
        return seatsRepository.save(seats);
    }

    @Override
    public void updateStatus(String seatNumber, String studioName, String statusUpdated) {
        seatsRepository.updateStatus(seatNumber, studioName, statusUpdated);
    }
}
