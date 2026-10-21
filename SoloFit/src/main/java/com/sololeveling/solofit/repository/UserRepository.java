package com.sololeveling.solofit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sololeveling.solofit.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByNameContainingIgnoreCase(String name);
}
