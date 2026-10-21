package com.sololeveling.solofit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sololeveling.solofit.model.User;
import com.sololeveling.solofit.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student (" + id + ") not found"));
    }

    public List<User> findByName(String name) {
        List<User> users = userRepository.findByNameContainingIgnoreCase(name);
        if (users.isEmpty()) {
            throw new EntityNotFoundException("No users found matching (" + name + ")");
        }
        return users;
    }

    public User changeGoal(int id, String newGoal){
        User user = userRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User (" + id + ") not found"));

        user.setGoal(newGoal);
        return userRepository.save(user);
    }

    public User addUser(String name, String goal){
        User user = new User();
        user.setName(name);
        user.setGoal(goal);
        return userRepository.save(user);
    }
}
