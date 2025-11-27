package com.example.Rewaya.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
public class Tip{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min=8,max = 480, message = "Tips maximum length is 480 character")
    private String content;


    @PositiveOrZero
    @Column(columnDefinition = "int default 0")
    private int likes;

    @NotEmpty(message = "log in as author")
    private Integer authorId;

}
