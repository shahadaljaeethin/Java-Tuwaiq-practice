package com.example.Rewaya.Service;

import com.example.Rewaya.Model.Author;
import com.example.Rewaya.Model.JoinRequest;
import com.example.Rewaya.Model.Meeting;
import com.example.Rewaya.Model.User;
import com.example.Rewaya.Repository.AuthorRepository;
import com.example.Rewaya.Repository.JoinRequestRepository;
import com.example.Rewaya.Repository.MeetingRepository;
import com.example.Rewaya.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class JoinRequestService {
    private final MeetingRepository meetingRepository;
    private final JoinRequestRepository joinRequestRepository;
    private final MeetingService meetingService;
    private final UserRepository userRepository;

    //add
    public String sendRequest(JoinRequest jr){

        Meeting meeting = meetingRepository.findMeetingById(jr.getMeetingId());
        if(meeting==null) return "meeting not found or cancelled";
        if(meeting.getLimitListeners()==meeting.getListeners().size()) return "this meeting is full";

        User user = userRepository.findUserById(jr.getUserId());
        if(user==null) return "log in as user";


        //if author set meeting to Auto accept by available seats :
        if(!meeting.isAcceptManually()){
            //set status to approved :)
            if(responseJoinRequest(jr.getId(),true).equals("status changed"))
                return "your request is approved! link details are sent to your email";

        }
        else jr.setStatus("pending");





        //notify author
        return "Request sent to the Author :)";

    }

    public List<JoinRequest> allJr(){return joinRequestRepository.findAll();}

    public boolean updateJoinRequest(Integer id,JoinRequest edit){
        JoinRequest jr = joinRequestRepository.findJoinRequestById(id);
        if(jr==null) return false;


        jr.setMessage(edit.getMessage());
         joinRequestRepository.save(jr);
         return true;

    }

    public boolean cancelJr(Integer id){
        JoinRequest jr = joinRequestRepository.findJoinRequestById(id);
        if(jr==null) return false;
        joinRequestRepository.delete(jr);
        return true;
    }
    //================================================= Extra End Points :

    public String responseJoinRequest(Integer jrId,boolean approved){

        JoinRequest jr = joinRequestRepository.findJoinRequestById(jrId);
        if(jr==null) return "Join request not found or deleted";

        if(approved){
        Meeting meeting = meetingRepository.findMeetingById(jr.getMeetingId());
        if(meeting.getLimitListeners()==meeting.getListeners().size()) return "this meeting is full";
        meetingService.addListener(jr.getUserId(), jr.getMeetingId());
        jr.setStatus("approved");
        joinRequestRepository.save(jr);
        //send meeting link to the user

         }
        else{
            jr.setStatus("rejected");
            joinRequestRepository.save(jr);
            }


        return "status changed";
    }
}
