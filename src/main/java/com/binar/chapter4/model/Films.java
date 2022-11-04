package com.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "films")
@Getter
@Setter
public class Films {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "film_code")
    private Long filmCode;

    @Column(name = "film_name")
    private String filmName;

    @Column(name = "is_playing")
    private boolean isPlaying;

    @OneToMany
    private List<Schedules> listFilm;

}
