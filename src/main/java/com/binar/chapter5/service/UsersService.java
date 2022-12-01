package com.binar.chapter5.service;

import com.binar.chapter5.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {

    List<Users> getUsers();

    Users addUser (Users users);

    Users updateUser (String username, Users users);

    boolean deleteUser (String username);

}
