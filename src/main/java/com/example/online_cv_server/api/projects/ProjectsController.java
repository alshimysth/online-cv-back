package com.example.online_cv_server.api.projects;

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
@RequestMapping(value = "/api/projectss", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectsController {

    private final ProjectsService projectsService;

    public ProjectsController(final ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectsModel>> getAllProjectss() {
        return ResponseEntity.ok(projectsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectsModel> getProjects(@PathVariable(name = "id") final Integer id) {
        return ResponseEntity.ok(projectsService.get(id));
    }

    @PostMapping
    public ResponseEntity<Integer> createProjects(
            @RequestBody @Valid final ProjectsModel projectsModel) {
        final Integer createdId = projectsService.create(projectsModel);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateProjects(@PathVariable(name = "id") final Integer id,
            @RequestBody @Valid final ProjectsModel projectsModel) {
        projectsService.update(id, projectsModel);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjects(@PathVariable(name = "id") final Integer id) {
        projectsService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
