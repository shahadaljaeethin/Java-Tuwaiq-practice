package com.example.Rewaya.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Chapter{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "enter the title")
    @Size(min=1,max=40,message = "title length must be between 1-40 char")
    @Column(columnDefinition = "varchar(40) not null")
    private String title;

    @NotEmpty(message = "enter the content")
    @Lob
    private String content;

    @PastOrPresent
    private LocalDate publishDate;

    @Column(columnDefinition = "int not null")
    private Integer chapterNumber;

    @NotNull(message = "enter the novel id of this chapter")
    private Integer novelId;

}
