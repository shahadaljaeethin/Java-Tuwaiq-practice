package com.example.Rewaya.Model;
import jakarta.persistence.*;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Novel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Enter Novel title")
    @Size(min=2,max=25,message = "Novel title must be between 2-25 char")
    @Column(columnDefinition = "varchar(25) not null")
    private String title;

    @NotEmpty(message = "Enter Novel overview")
    @Size(min=100,max=500,message = "Novel overview must be between 100-500 char")
    @Lob
    private String overview;

    @NotEmpty(message = "log in as author")
    @Pattern(regexp = "(?i)^(Fantasy|SciFi|Romance|Drama|Action|Horror|Mystery|Thriller|Historical|Comedy|YoungAdult|Psychological|Social|Detective|Adventure|Philosophical)$",
            message = "Invalid novel category")
    private String category;

    @AssertFalse
    @Column(nullable = false)
    private Boolean isCompleted;

    @Column(columnDefinition = "int default 0 not null")
    private Integer likes;

    @PastOrPresent
    private LocalDate publishDate;

    @NotNull(message = "log in as author")
    private Integer authorId;

}

