package com.example.Rewaya.Service;

import com.example.Rewaya.Model.Author;
import com.example.Rewaya.Model.Meeting;
import com.example.Rewaya.Repository.AuthorRepository;
import com.example.Rewaya.Repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingService {
    private final MeetingRepository meetingRepository;
    private final AuthorRepository authorRepository;


    public String announceMeeting(Meeting meeting){
        Author author = authorRepository.findAuthorById(meeting.getAuthorId());
        if(author==null) return "author not found";
        if(meeting.getEndDate().isBefore(meeting.getStartDate())) return "End time should be after start date";

        meetingRepository.save(meeting);
        return "meeting announced :) thank you for supporting community";
    }

    public List<Meeting> allMeeting(){return meetingRepository.findAll();}

    public String updateMeeting(Integer id,Meeting edit){
        Meeting meeting = meetingRepository.findMeetingById(id);
        if(meeting==null) return "meeting not found";

        if(edit.getEndDate().isBefore(edit.getStartDate())) return "End time should be after start date";

        //===
        meeting.setStartDate(edit.getStartDate());
        meeting.setEndDate(edit.getEndDate());
        meeting.setLimitListeners(edit.getLimitListeners());
        meeting.setLinkURL(edit.getLinkURL());

        meetingRepository.save(meeting);
        return "updated";

    }

    public boolean cancelMeeting(Integer id){
        Meeting meeting = meetingRepository.findMeetingById(id);
        if(meeting==null) return false;
        meetingRepository.delete(meeting);
        return true;
    }

    //===================< E N D of C R U D >========================================< Start E.E.P >====================\\

    public void addListener(Integer userId,Integer meetingId){

        Meeting meeting = meetingRepository.findMeetingById(meetingId);
        ArrayList<Integer> upd = meeting.getListeners();
        upd.add(userId);
        meeting.setListeners(upd);

    }



}
