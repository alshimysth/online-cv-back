package com.example.online_cv_server.api.skills;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SkillsModel {

    private Integer id;

    @NotNull
    @Size(max = 50)
    private String skillName;

    @Size(max = 50)
    private String category;

    @Size(max = 15)
    private String proficiencyLevel;

}
