package com.example.LMS.Model;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
@Data
@AllArgsConstructor
public class Section {
    @NotEmpty(message = "write id")
    @Size(min=6,max=6,message = "")
    private String id;

    @NotEmpty(message = "write linked course id")
    private String courseID;

    @NotEmpty(message = "enter registered students")
    @Size(min=2,max=40,message = "students can be from 2-40 per section")
    public ArrayList<Student> students = new ArrayList<>();

    @NotEmpty(message = "enter schedule")
    public LocalTime[] schedule = new LocalTime[5]; //from Sunday to Thursday
    @NotNull(message = "enter availability status")
    @AssertTrue     //it must be available since it has students
    private boolean isAvailable;
}
