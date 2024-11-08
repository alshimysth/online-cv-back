package com.example.online_cv_server.api.skills;

import com.example.online_cv_server.entities.Skills;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SkillsRepository extends JpaRepository<Skills, Integer> {
}
