package com.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "seats")
@Getter
@Setter
public class Seats {

    @EmbeddedId
    private SeatsId seatsId;

//    @Column(name = "seats_id")
//    private Integer seatsId;

    @Column(name = "studio_name")
    private Character studioName;

}
