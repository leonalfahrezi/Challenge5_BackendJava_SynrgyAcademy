package com.binar.chapter5.repository;

import com.binar.chapter5.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmsRepository extends JpaRepository<Films, String> {
    @Query(value = "select * from films", nativeQuery = true)
    List<Films> getAllFilms();
}
