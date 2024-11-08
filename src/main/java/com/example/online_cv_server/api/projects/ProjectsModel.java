package com.example.online_cv_server.api.projects;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
public class ProjectsModel {

    private Integer id;

    @NotNull
    @Size(max = 100)
    private String projectName;

    private String description;

    private String technologiesUsed;

    private LocalDate startDate;

    private LocalDate endDate;

    @Size(max = 255)
    private String link;

}
