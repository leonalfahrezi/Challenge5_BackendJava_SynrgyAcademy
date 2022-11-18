package com.binar.chapter4.service;

import com.binar.chapter4.model.Users;
import com.binar.chapter4.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<Users> getUsers() {
            return usersRepository.findAll();
    }

    @Override
    public Users addUser(Users users) {

        Optional<Users> usersAdd = usersRepository.findById(users.getUsername());
        if (usersAdd.isPresent()) {
            System.out.println("User has been registered before, try another!");
        }

        return usersRepository.save(users);

    }

    @Override
    public Users updateUser(String username, Users users) {

        Optional<Users> usersUpdate = usersRepository.findById(users.getUsername());
        usersUpdate.get().setEmail(users.getEmail());
        usersUpdate.get().setPassword(users.getPassword());
        usersUpdate.get().setUsername(users.getUsername());
        return usersRepository.save(users);

    }

    @Override
    public boolean deleteUser(String username) {

        Optional<Users> usersDelete = usersRepository.findById(username);
        usersRepository.deleteById(username);

        if (!usersDelete.isPresent()) {
            System.out.println("User has been deleted!");
        }

        return true;

    }
}
