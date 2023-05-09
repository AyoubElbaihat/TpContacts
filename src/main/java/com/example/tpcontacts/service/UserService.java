package com.example.tpcontacts.service;

import com.example.tpcontacts.repository.UserRepository;
import com.example.tpcontacts.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

}
