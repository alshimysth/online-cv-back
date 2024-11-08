package com.example.online_cv_server.api.hobbies;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class HobbiesModel {

    private Integer id;

    @NotNull
    @Size(max = 100)
    private String hobbyName;

    private String description;

}
