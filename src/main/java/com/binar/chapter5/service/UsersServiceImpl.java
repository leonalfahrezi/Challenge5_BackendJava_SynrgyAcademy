package com.binar.chapter5.service;

import com.binar.chapter5.model.Users;
import com.binar.chapter5.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Users getUser() {
        return usersRepository.getUsers();
    }

    @Override
    public Users addUser(Users id) {
        Optional<Users> usersAdd = usersRepository.findById(id.getId());
        if (usersAdd.isPresent()) {
            System.out.println("User has been registered before, try another!");
        }
        return usersRepository.save(id);
    }

    @Override
    public void updateUser(Users users) {
        Optional<Users> usersUpdate = usersRepository.findById(users.getId());
        if (!usersUpdate.isPresent()) {
            usersUpdate.get().setEmail(users.getEmail());
            usersUpdate.get().setPassword(users.getPassword());
            usersUpdate.get().setUsername(users.getUsername());
            usersRepository.save(users);
        } else
            System.out.println("User has been registered before, try another!");
    }

    @Override
    public boolean deleteUser(Integer id) {
        Optional<Users> usersDelete = usersRepository.findById(id);
        usersRepository.deleteById(id);
        if (!usersDelete.isPresent()) {
            System.out.println("User has been deleted!");
        }
        return true;
    }
}
