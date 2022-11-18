package com.binar.chapter4.repository;

import com.binar.chapter4.model.Films;
import com.binar.chapter4.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchedulesRepository extends JpaRepository<Schedules, Integer> {
    @Query(value = "select * from schedules", nativeQuery = true)
    List<Schedules> getSchedules();
}
