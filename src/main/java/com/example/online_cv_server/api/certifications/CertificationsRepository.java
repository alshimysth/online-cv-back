package com.example.online_cv_server.api.certifications;

import com.example.online_cv_server.entities.Certifications;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CertificationsRepository extends JpaRepository<Certifications, Integer> {
}
