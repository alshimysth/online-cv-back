package com.example.online_cv_server.api.certifications;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/certificationss", produces = MediaType.APPLICATION_JSON_VALUE)
public class CertificationsController {

    private final CertificationsService certificationsService;

    public CertificationsController(final com.example.online_cv_server.api.certifications.CertificationsService certificationsService) {
        this.certificationsService = certificationsService;
    }

    @GetMapping
    public ResponseEntity<List<CertificationsModel>> getAllCertifications() {
        return ResponseEntity.ok(certificationsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.example.online_cv_server.api.certifications.CertificationsModel> getCertifications(
            @PathVariable(name = "id") final Integer id) {
        return ResponseEntity.ok(certificationsService.get(id));
    }

    @PostMapping
    public ResponseEntity<Integer> createCertifications(
            @RequestBody @Valid final com.example.online_cv_server.api.certifications.CertificationsModel certificationsModel) {
        final Integer createdId = certificationsService.create(certificationsModel);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateCertifications(@PathVariable(name = "id") final Integer id,
            @RequestBody @Valid final com.example.online_cv_server.api.certifications.CertificationsModel certificationsModel) {
        certificationsService.update(id, certificationsModel);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertifications(@PathVariable(name = "id") final Integer id) {
        certificationsService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
