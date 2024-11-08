package com.example.online_cv_server.api.skills;

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
@RequestMapping(value = "/api/skillss", produces = MediaType.APPLICATION_JSON_VALUE)
public class SkillsController {

    private final SkillsService skillsService;

    public SkillsController(final SkillsService skillsService) {
        this.skillsService = skillsService;
    }

    @GetMapping
    public ResponseEntity<List<SkillsModel>> getAllSkillss() {
        return ResponseEntity.ok(skillsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillsModel> getSkills(@PathVariable(name = "id") final Integer id) {
        return ResponseEntity.ok(skillsService.get(id));
    }

    @PostMapping
    public ResponseEntity<Integer> createSkills(@RequestBody @Valid final SkillsModel skillsModel) {
        final Integer createdId = skillsService.create(skillsModel);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateSkills(@PathVariable(name = "id") final Integer id,
            @RequestBody @Valid final SkillsModel skillsModel) {
        skillsService.update(id, skillsModel);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkills(@PathVariable(name = "id") final Integer id) {
        skillsService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
