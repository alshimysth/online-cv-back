package com.example.online_cv_server.api.projects;

import com.example.online_cv_server.entities.Projects;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectsRepository extends JpaRepository<Projects, Integer> {
}
