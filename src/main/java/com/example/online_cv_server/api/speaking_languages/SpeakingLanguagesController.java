package com.example.online_cv_server.api.speaking_languages;

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
@RequestMapping(value = "/api/speakingLanguagess", produces = MediaType.APPLICATION_JSON_VALUE)
public class SpeakingLanguagesController {

    private final SpeakingLanguagesService speakingLanguagesService;

    public SpeakingLanguagesController(final SpeakingLanguagesService speakingLanguagesService) {
        this.speakingLanguagesService = speakingLanguagesService;
    }

    @GetMapping
    public ResponseEntity<List<SpeakingLanguagesModel>> getAllSpeakingLanguagess() {
        return ResponseEntity.ok(speakingLanguagesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpeakingLanguagesModel> getSpeakingLanguages(
            @PathVariable(name = "id") final Integer id) {
        return ResponseEntity.ok(speakingLanguagesService.get(id));
    }

    @PostMapping
    public ResponseEntity<Integer> createSpeakingLanguages(
            @RequestBody @Valid final SpeakingLanguagesModel speakingLanguagesModel) {
        final Integer createdId = speakingLanguagesService.create(speakingLanguagesModel);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateSpeakingLanguages(
            @PathVariable(name = "id") final Integer id,
            @RequestBody @Valid final SpeakingLanguagesModel speakingLanguagesModel) {
        speakingLanguagesService.update(id, speakingLanguagesModel);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpeakingLanguages(
            @PathVariable(name = "id") final Integer id) {
        speakingLanguagesService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
