package com.example.online_cv_server.api.educations;

import com.example.online_cv_server.entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EducationRepository extends JpaRepository<Education, Integer> {
}
