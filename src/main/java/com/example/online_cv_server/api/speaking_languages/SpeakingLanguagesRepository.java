package com.example.online_cv_server.api.speaking_languages;

import com.example.online_cv_server.entities.SpeakingLanguages;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SpeakingLanguagesRepository extends JpaRepository<SpeakingLanguages, Integer> {
}
