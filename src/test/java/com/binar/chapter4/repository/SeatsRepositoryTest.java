package com.binar.chapter4.repository;

import com.binar.chapter4.model.Seats;
import com.binar.chapter4.model.SeatsId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
public class SeatsRepositoryTest {

    @Autowired
    SeatsRepository seatsRepository;

    @Test
    void getStudioSeatTest() {
        List<Seats> test = seatsRepository.getStudioSeatStatus();
        Assertions.assertNotNull(test);
    }

}
