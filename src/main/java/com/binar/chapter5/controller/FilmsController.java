package com.binar.chapter5.controller;

import com.binar.chapter5.model.Films;
import com.binar.chapter5.model.Schedules;
import com.binar.chapter5.model.request.FilmsRequest;
import com.binar.chapter5.model.response.FilmsResponse;
import com.binar.chapter5.service.FilmsServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/films")
public class FilmsController {

    @Autowired
    FilmsServiceImpl filmsService;

    @Operation(summary = "add new film to system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "request success",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FilmsResponse.class)))
    })
    @PostMapping("/add_films")
    public ResponseEntity addFilms(@RequestBody FilmsRequest addRequest) {
        try {
            Films films = new Films();
            films.setFilmCode(addRequest.getFilmCode());
            films.setFilmName(addRequest.getFilmName());
            films.setPlaying(addRequest.isPlaying());
            filmsService.addFilm(films);

            Schedules schedules = new Schedules();
            schedules.setScheduleId(schedules.getScheduleId());
            schedules.setFilmCode(schedules.getFilmCode());
            schedules.setPlayingDate(schedules.getPlayingDate());
            schedules.setStartingTime(schedules.getStartingTime());
            schedules.setEndingTime(schedules.getEndingTime());
            schedules.setTicketPrice(schedules.getTicketPrice());
            filmsService.addSchedule(schedules);

            return ResponseEntity.status(HttpStatus.OK).body("add success (CODE 200)");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("add failed (CODE 502), caused by : " + e.getMessage());
        }
    }

    @Operation(summary = "update film from system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "request success",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FilmsResponse.class)))
    })
    @PutMapping("/update_film")
    public ResponseEntity updateFilms(@RequestParam("films") Films films) {
        try {
            filmsService.updateFilm(films);
            return ResponseEntity.status(HttpStatus.OK).body("update success (CODE 200)");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("update failed (CODE 502), caused by : " + e.getMessage());
        }
    }

    @Operation(summary = "update film from system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "request success",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FilmsResponse.class)))
    })
    @DeleteMapping("/delete_film")
    public ResponseEntity deleteFilms(@RequestParam("film_name") String filmName) {
        try {
            filmsService.deleteFilm(filmName);
            return ResponseEntity.status(HttpStatus.OK).body("update success (CODE 200)");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("update failed (CODE 502), caused by : " + e.getMessage());
        }
    }

    @Operation(summary = "show film is playing")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "request success",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FilmsResponse.class)))
    })
    @GetMapping("/get_film")
    public ResponseEntity getFilms() {
        try {
            filmsService.getFilm();
            return ResponseEntity.status(HttpStatus.OK).body("show success (CODE 200)");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("failed to show (CODE 502), caused by : " + e.getMessage());
        }
    }
}


