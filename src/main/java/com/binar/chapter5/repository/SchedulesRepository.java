package com.binar.chapter5.repository;

import com.binar.chapter5.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchedulesRepository extends JpaRepository<Schedules, Integer> {
    @Query(value = "select * from schedules", nativeQuery = true)
    List<Schedules> getSchedules();

    @Query(value = "select playing_ from schedules", nativeQuery = true)
    Schedules getSchedulesDate();
}
