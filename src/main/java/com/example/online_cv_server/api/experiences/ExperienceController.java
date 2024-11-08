package com.example.online_cv_server.api.experiences;

import jakarta.validation.Valid;
import java.util.List;
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
@RequestMapping(value = "/api/experiences", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(final ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping
    public ResponseEntity<List<ExperienceModel>> getAllExperiences() {
        return ResponseEntity.ok(experienceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceModel> getExperience(
            @PathVariable(name = "id") final Integer id) {
        return ResponseEntity.ok(experienceService.get(id));
    }

    @PostMapping
    public ResponseEntity<Integer> createExperience(
            @RequestBody @Valid final ExperienceModel experienceModel) {
        final Integer createdId = experienceService.create(experienceModel);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateExperience(@PathVariable(name = "id") final Integer id,
            @RequestBody @Valid final ExperienceModel experienceModel) {
        experienceService.update(id, experienceModel);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable(name = "id") final Integer id) {
        experienceService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
