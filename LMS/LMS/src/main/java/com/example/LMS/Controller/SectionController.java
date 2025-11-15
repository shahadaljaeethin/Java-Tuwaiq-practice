package com.example.LMS.Controller;

import com.example.LMS.Model.Section;
import com.example.LMS.Model.Student;
import com.example.LMS.Service.SectionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/section")
@RequiredArgsConstructor
public class SectionController {

    private final SectionService sectionService;

    //==================================== C R U D ===================================

    @PostMapping("/add")
    public ResponseEntity<?> createSection(@RequestBody @Valid Section section, Errors errors){
        if (errors.hasErrors()) return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        sectionService.createSection(section);
        return ResponseEntity.status(200).body("Section created successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllSections() {
        return ResponseEntity.status(200).body(sectionService.getAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSection(@PathVariable String id, @RequestBody @Valid Section section,Errors errors){
        if (errors.hasErrors())return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (!sectionService.updateSection(id, section))
            return ResponseEntity.status(400).body("Section not found");

        return ResponseEntity.status(200).body("Section updated");
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeSection(@PathVariable String id){
             if (!sectionService.removeSection(id))
            return ResponseEntity.status(400).body("Section not found");

        return ResponseEntity.status(200).body("Section removed");
    }

    //====================================================================

    @PostMapping("get/day and time/{day}")
    public ResponseEntity<?> getSectionsByTime(@PathVariable int day,@RequestBody ArrayList<LocalTime> timeRange){
        //read time range
        LocalTime min = timeRange.get(0);
        LocalTime max = timeRange.get(1);

        ArrayList<Section> filter = sectionService.getSectionsByTime(min,max,day);

        if (filter == null) return ResponseEntity.status(400).body("Day must be a number between Sunday(1) to Thursday(5)");
        if(filter.isEmpty()) return ResponseEntity.status(400).body("There is no section study at this range");

        return ResponseEntity.status(200).body(filter);
    }

    @PutMapping("/disable/{id}")
    public ResponseEntity<?> disable(@PathVariable String id){

        if (sectionService.disableSection(id))
            return ResponseEntity.status(200).body("Section set to disable");

        return ResponseEntity.status(400).body("Error: the section is disabled before");

    }

    @PutMapping("/re-open/{id}")
    public ResponseEntity<?> reOpen(@PathVariable String id, @RequestBody ArrayList<Student> students){
        if (!sectionService.reOpenSection(id,students))
            return ResponseEntity.status(400).body("Error: the section is available already before");

        return ResponseEntity.status(200).body("Section re-opened");
    }


    @PutMapping("/add student/{id}")
    public ResponseEntity<?> addStudent(@PathVariable String id,@RequestBody @Valid Student student, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        if (!sectionService.addStudentToSec(id,student))
            return ResponseEntity.status(400).body("Section not found or unavailable");

        return ResponseEntity.status(200).body("Student added to the selected section");
    }

}
