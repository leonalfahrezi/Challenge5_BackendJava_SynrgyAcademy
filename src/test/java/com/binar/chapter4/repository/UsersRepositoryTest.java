package com.binar.chapter4.repository;

import com.binar.chapter4.model.Users;
import com.binar.chapter4.service.UsersServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;
    UsersServiceImpl usersServiceImpl;

    @Test
    void getUsersTest() {
        List<Users> test = usersRepository.getUsers();
        Assertions.assertNotNull(test);
    }

    @Test
    void addUsersTest1() {
        Users users = new Users();
        users.setId(101);
        users.setUsername("leona");
        users.setEmail("leona@gmail.com");
        users.setPassword("leonaajah123");
        usersRepository.save(users);
    }

    @Test
    void addUsersTest2() {
        Users users1 = new Users();
        users1.setId(102);
        users1.setUsername("jokowi");
        users1.setEmail("jokowi@gmail.com");
        users1.setPassword("jokowiajah123");
        usersRepository.save(users1);
    }
}
