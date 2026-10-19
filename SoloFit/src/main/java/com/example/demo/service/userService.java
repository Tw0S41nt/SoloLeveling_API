package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findById(int id){
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student (" + id + ") not found"));
    }

    public List<User> findByName(String name){
        List<User> users = userRepository.findByNameContainingIgnoreCase(name);
        if (users.isEmpty()) {
            throw new EntityNotFoundException("No users found matching (" + name + ")");
        }
        return users;
         }
}
