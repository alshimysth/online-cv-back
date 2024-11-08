package com.example.online_cv_server.api.experiences;

import com.example.online_cv_server.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
}
