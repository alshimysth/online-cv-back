package com.example.online_cv_server.api.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserModel {

    private Integer id;

    @NotNull
    @Size(max = 50)
    private String firstName;

    @NotNull
    @Size(max = 50)
    private String lastName;

    @NotNull
    @Size(max = 100)
    private String email;

    @Size(max = 20)
    private String phone;

    @Size(max = 255)
    private String address;

    @Size(max = 255)
    private String linkedin;

    @Size(max = 255)
    private String github;

    private String summary;

    @Size(max = 255)
    private String profilePicture;

}
