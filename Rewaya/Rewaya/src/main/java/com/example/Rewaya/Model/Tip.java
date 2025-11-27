package com.example.Rewaya.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tip{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min=8,max = 480, message = "Tips maximum length is 480 character")
    private String content;

    @PastOrPresent
    private LocalDate publishDate;

    @PositiveOrZero
    @Column(columnDefinition = "int default 0")
    private Integer likes;

    @NotEmpty(message = "log in as author")
    private Integer authorId;

}
