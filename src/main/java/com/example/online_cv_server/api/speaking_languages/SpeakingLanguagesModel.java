package com.example.online_cv_server.api.speaking_languages;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SpeakingLanguagesModel {

    private Integer id;

    @NotNull
    @Size(max = 50)
    private String languageName;

    @Size(max = 15)
    private String proficiencyLevel;

}
