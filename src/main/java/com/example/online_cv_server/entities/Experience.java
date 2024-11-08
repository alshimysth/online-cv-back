package com.example.online_cv_server.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
public class Experience {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer id;

    @Column(nullable = false, length = 100)
    private String jobTitle;

    @Column(length = 100)
    private String companyName;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column(length = 100)
    private String location;

    @Column(columnDefinition = "text")
    private String description;

}
