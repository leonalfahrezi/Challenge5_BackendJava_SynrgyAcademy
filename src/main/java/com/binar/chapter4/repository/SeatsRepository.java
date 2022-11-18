package com.binar.chapter4.repository;

import com.binar.chapter4.model.Seats;
import com.binar.chapter4.model.SeatsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface SeatsRepository extends JpaRepository<Seats, SeatsId> {

    @Modifying
    @Query(value = "CALL UPDATE_STATUS(:seatNumber, :studioName, :statusUpdated)", nativeQuery = true)
    void updateStatus (@Param("seatNumber") String seatNumber, @Param("studioName") String studioName, @Param("statusUpdated") String statusUpdated);

    @Query(value = "select * from seats", nativeQuery = true)
    List<Seats> getStudioSeatStatus();
}
