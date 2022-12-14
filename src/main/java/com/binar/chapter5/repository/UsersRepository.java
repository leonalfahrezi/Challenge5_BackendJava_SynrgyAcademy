package com.binar.chapter5.repository;

import com.binar.chapter5.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query(value = "select * from users", nativeQuery = true)
    List<Users> getAllUsers();
    @Query(value = "select username from users", nativeQuery = true)
    Users getUsers();
}
