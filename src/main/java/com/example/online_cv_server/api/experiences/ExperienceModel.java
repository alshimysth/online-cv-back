package com.example.online_cv_server.api.experiences;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
public class ExperienceModel {

    private Integer id;

    @NotNull
    @Size(max = 100)
    private String jobTitle;

    @Size(max = 100)
    private String companyName;

    private LocalDate startDate;

    private LocalDate endDate;

    @Size(max = 100)
    private String location;

    private String description;

}
