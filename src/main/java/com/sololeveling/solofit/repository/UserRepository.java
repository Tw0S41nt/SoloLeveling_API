package com.sololeveling.solofit.repository;

import com.sololeveling.solofit.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
  List<User> findByNameContainingIgnoreCase(String name);
}
