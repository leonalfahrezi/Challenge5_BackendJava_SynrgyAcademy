package com.binar.chapter4.repository;

import com.binar.chapter4.model.Seats;
import com.binar.chapter4.model.SeatsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, SeatsId> {
}
