package com.example.online_cv_server.api.hobbies;

import com.example.online_cv_server.entities.Hobbies;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HobbiesRepository extends JpaRepository<Hobbies, Integer> {
}
