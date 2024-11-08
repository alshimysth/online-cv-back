package com.example.online_cv_server.api.user;

import com.example.online_cv_server.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
