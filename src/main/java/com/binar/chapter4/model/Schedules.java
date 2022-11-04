package com.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "schedules")
@Getter
@Setter
public class Schedules {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(name = "film_code")
    private Long filmCode;

    @Column(name = "playing_date")
    private String playingDate;

    @Column(name = "starting_time")
    private String startingTime;

    @Column(name = "ending_time")
    private String endingTime;

    @Column(name = "ticket_price")
    private Long ticketPrice;

    @ManyToOne
    private Films film;

}
