package com.ordering_system.service;

import com.ordering_system.model.dto.User;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService{
    User getByEmail(String email);
    User getById(long id);
    List<User> getAll();
    User save(User user);

    void update(String email, User user);
    void delete(long id);
}
