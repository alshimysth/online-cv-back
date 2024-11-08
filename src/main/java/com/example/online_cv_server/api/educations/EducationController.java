package com.example.online_cv_server.api.educations;

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
@RequestMapping(value = "/api/educations", produces = MediaType.APPLICATION_JSON_VALUE)
public class EducationController {

    private final EducationService educationService;

    public EducationController(final EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping
    public ResponseEntity<List<EducationModel>> getAllEducations() {
        return ResponseEntity.ok(educationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationModel> getEducation(@PathVariable(name = "id") final Integer id) {
        return ResponseEntity.ok(educationService.get(id));
    }

    @PostMapping
    public ResponseEntity<Integer> createEducation(
            @RequestBody @Valid final EducationModel educationModel) {
        final Integer createdId = educationService.create(educationModel);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateEducation(@PathVariable(name = "id") final Integer id,
            @RequestBody @Valid final EducationModel educationModel) {
        educationService.update(id, educationModel);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable(name = "id") final Integer id) {
        educationService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
