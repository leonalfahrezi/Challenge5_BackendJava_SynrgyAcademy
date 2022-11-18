package com.binar.chapter4.repository;

import com.binar.chapter4.model.Films;
import com.binar.chapter4.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
    @Query(value = "select * from users", nativeQuery = true)
    List<Users> getUsers();
}
