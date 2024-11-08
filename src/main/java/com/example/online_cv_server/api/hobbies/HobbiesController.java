package com.example.online_cv_server.api.hobbies;

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
@RequestMapping(value = "/api/hobbiess", produces = MediaType.APPLICATION_JSON_VALUE)
public class HobbiesController {

    private final HobbiesService hobbiesService;

    public HobbiesController(final HobbiesService hobbiesService) {
        this.hobbiesService = hobbiesService;
    }

    @GetMapping
    public ResponseEntity<List<HobbiesModel>> getAllHobbiess() {
        return ResponseEntity.ok(hobbiesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HobbiesModel> getHobbies(@PathVariable(name = "id") final Integer id) {
        return ResponseEntity.ok(hobbiesService.get(id));
    }

    @PostMapping
    public ResponseEntity<Integer> createHobbies(@RequestBody @Valid final HobbiesModel hobbiesModel) {
        final Integer createdId = hobbiesService.create(hobbiesModel);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateHobbies(@PathVariable(name = "id") final Integer id,
            @RequestBody @Valid final HobbiesModel hobbiesModel) {
        hobbiesService.update(id, hobbiesModel);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHobbies(@PathVariable(name = "id") final Integer id) {
        hobbiesService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
