package com.example.online_cv_server.api.educations;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
public class EducationModel {

    private Integer id;

    @NotNull
    @Size(max = 100)
    private String institutionName;

    @Size(max = 100)
    private String degree;

    @Size(max = 100)
    private String fieldOfStudy;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

}
