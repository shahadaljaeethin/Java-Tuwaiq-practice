package com.example.LMS.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

@NotEmpty(message = "write id")
@Size(min=10,max=10,message = "id length must be 10")
private String id;

@NotEmpty(message = "write title")
@Size(min=8,max=25,message = "title length must be between 8-25")
private String title;

@NotEmpty(message = "write code")
@Size(min=6,max=6,message = "code length must 6 ")
private String course_code;

@NotEmpty(message = "content needed")
@Size(min=4,message = "content minimum is 4")
private ArrayList<Content> contents = new ArrayList<>();

@NotNull(message = "enter level")
@Min(value=1,message = "level must be from 1 to 8")
@Max(value = 8,message = "level must be from 1 to 8")
private int level;

@NotNull(message = "enter credit hours")
@Min(value = 1,message = "credit hours must be from 1 to 4")
@Max(value = 4,message = "credit hours must be from 1 to 4")
private int creditHours;
//it can be empty, especially for the first level
@Size(max=10,message = "max prerequisite is 10")
public ArrayList<String> prerequisite_courses_IDs = new ArrayList<>();

}
