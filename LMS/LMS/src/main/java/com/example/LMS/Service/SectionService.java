package com.example.LMS.Service;

import com.example.LMS.Model.Section;
import com.example.LMS.Model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalTime;
import java.util.ArrayList;

@Service
public class SectionService {
//=========================C R U D===========================================
    ArrayList<Section> sections = new ArrayList<>();
    //-
    public void createSection(Section s) {
        sections.add(s);
    }

    public ArrayList<Section> getAll(){return sections;}

    public boolean updateSection(String id, Section s){
    if(findSection(id)==-1) return false;
    sections.set(findSection(id),s);
    return true;
    }

    public boolean removeSection(String id){
        if(findSection(id)==-1) return false;
        sections.remove(findSection(id));
        return true;
    }

//============================================================Extra points
public int findSection(String id){
    for(int i=0;i<sections.size();i++)if(sections.get(i).getId().equals(id))return i;
    return -1; //not found
}

//(1) find all sections who study in this time range with specific day (1-5)

    public ArrayList<Section> getSectionsByTime(LocalTime min, LocalTime max,int day){
        if(day>5||day<1) return null; //invalid day

        LocalTime time;
        boolean range;
        ArrayList<Section> sectionFilter = new ArrayList<>();
    for(Section sec:sections){
    time = sec.schedule[day-1];
    range = (!time.isBefore(min))&&(!time.isAfter(max));
    if(range) sectionFilter.add(sec);
    }
    return sectionFilter;
    }

//(2) disable a section
    public boolean disableSection(String id){
        if(findSection(id)==-1) return false;
        if(!sections.get(findSection(id)).isAvailable()) return false; //if already non-available
        sections.get(findSection(id)).setAvailable(false);
        sections.get(findSection(id)).setStudents(new ArrayList<Student>()); //empty student list
        return true;
    }


//(3) re-open a section

public boolean reOpenSection(String id,ArrayList<Student> newStudents){
    if(findSection(id)==-1) return false;
    if(sections.get(findSection(id)).isAvailable()) return false; //already available

    sections.get(findSection(id)).setAvailable(true);
    sections.get(findSection(id)).setStudents(newStudents);
    return true;
}

//(4) add a student to a section

    public boolean addStudentToSec(String id, Student student){
        if(findSection(id)==-1) return false;
        if(!sections.get(findSection(id)).isAvailable()) return false; //Not available

        sections.get(findSection(id)).students.add(student);
        return true;
    }

}
