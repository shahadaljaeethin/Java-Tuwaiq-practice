package com.example.LMS.Service;

import com.example.LMS.Api.ApiResponse;
import com.example.LMS.Model.Content;
import com.example.LMS.Model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {
    ArrayList<Course> courses = new ArrayList<>();
//======================================================= CRUDs :-
    public void addCourse(Course c){
    courses.add(c);
    }

    public ArrayList<Course> getAll(){return courses;}

    public boolean updateCourse(String id,Course c){
        if(findCourse(id)==-1) return false;
        courses.set(findCourse(id),c);
        return true;
    }

    public boolean removeCourse(String id){
        if(findCourse(id)==-1) return false;
        courses.remove(findCourse(id));
        return true;
    }
//========================================================== Extra points :-
    public int findCourse(String id){
        for(int i=0;i<courses.size();i++)if(courses.get(i).getId().equals(id))return i;
        return -1; //Course not found
    }
    //(1) extra End-Point : get course by ID

    public Course getCourse(String id){
        if(findCourse(id)==-1) return null;
        return courses.get(findCourse(id));
    }

    //(2) extra End-Point : update course level

    public boolean updateLevel(String id,int level){
        if(level>8||level<1) return false;
        if(findCourse(id)==-1) return false;
        courses.get(findCourse(id)).setLevel(level);
        return true;
    }

    //(3) extra End-Point : update content

    public boolean updateContent(String id, ArrayList<Content> newContent)
    {
        if(findCourse(id)==-1) return false;
        courses.get(findCourse(id)).setContents(newContent);
        return true;
    }

    //(4) extra End-Point : add prerequisite course

    public boolean addPrerequisiteCourses(String id, ApiResponse prerequisite){
        if(findCourse(id)==-1) return false;

        courses.get(findCourse(id)).prerequisite_courses_IDs.add(prerequisite.getMessage());
        return true;
    }




    //(X) get available courses of a major for given level
//     *** I think this end point might work with class (Major) more than (Course's)

//        public ArrayList<Course> getByLevel(int level,String major){
//        if(level>8||level<1) return null; //invalid level
//        //-
//        ArrayList<Course> levelFilter = new ArrayList<>();
//        for(Course c: courses) if(c.getLevel()<=level) levelFilter.add(c);
//        return levelFilter;
//    }

}
