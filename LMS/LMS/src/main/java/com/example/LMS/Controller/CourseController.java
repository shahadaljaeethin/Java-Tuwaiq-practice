package com.example.LMS.Controller;

import com.example.LMS.Api.ApiResponse;
import com.example.LMS.Model.Content;
import com.example.LMS.Model.Course;
import com.example.LMS.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
private final CourseService courseService;


    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid Course course, Errors errors){
        if(errors.hasErrors()) return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added"));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(200).body(courseService.getAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable String id, @RequestBody @Valid Course c,Errors errors){
        if(errors.hasErrors()) return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        //-
        if (!courseService.updateCourse(id,c))
            return ResponseEntity.status(400).body(new ApiResponse("Course not found"));
        return ResponseEntity.status(200).body(new ApiResponse("Course updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeCourse(@PathVariable String id) {
        if(courseService.removeCourse(id))
            return ResponseEntity.status(200).body(new ApiResponse("Course removed"));
        return ResponseEntity.status(400).body(new ApiResponse("Course not found"));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCourse(@PathVariable String id) {
        Course course = courseService.getCourse(id);
        if (course == null)
            return ResponseEntity.status(400).body(new ApiResponse("Course not found"));

        return ResponseEntity.status(200).body(course);
    }


    @PutMapping("/update/level/{id}/{level}")
    public ResponseEntity<?> updateLevel(@PathVariable String id, @PathVariable int level){

        if (courseService.updateLevel(id,level))
            return ResponseEntity.status(200).body(new ApiResponse("Level updated"));
        return ResponseEntity.status(400).body(new ApiResponse("course not found or invalid level"));

    }

    @PutMapping("/update/content/{id}")
    public ResponseEntity<?> updateContent(@PathVariable String id,@RequestBody ArrayList<Content> contents){
        if (courseService.updateContent(id,contents))
            return ResponseEntity.status(200).body(new ApiResponse("Content updated"));

      return ResponseEntity.status(400).body(new ApiResponse("course not found"));
    }


    @PutMapping("/add prerequisite/{id}")
    public ResponseEntity<?> addPrerequisite(@PathVariable String id,@RequestBody ApiResponse prerequisite){

        if (courseService.addPrerequisiteCourses(id,prerequisite))
            return ResponseEntity.status(200).body(new ApiResponse("prerequisite added to the list"));
      return ResponseEntity.status(400).body(new ApiResponse("Course not found"));

    }

}
