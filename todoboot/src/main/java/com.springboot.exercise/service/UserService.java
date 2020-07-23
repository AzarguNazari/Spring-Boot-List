package com.springboot.exercise.service;

import com.springboot.exercise.model.User;

import java.util.Collection;

public interface UserService {

    User save(User user);

    Boolean delete(int id);

    User update(User user);

    User findById(int id);

    User findByUserName(String username);

    User findByEmail(String email);

    Collection<User> findAll();
}
