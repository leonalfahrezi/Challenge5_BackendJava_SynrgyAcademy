package com.binar.chapter5.service;

import com.binar.chapter5.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {

    Users getUser();

    Users addUser (Users id);

    void updateUser (Users users);

    boolean deleteUser (Integer id);

}
