package com.example.Rewaya.Service;

import com.example.Rewaya.Model.Author;
import com.example.Rewaya.Model.Meeting;
import com.example.Rewaya.Model.User;
import com.example.Rewaya.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendEmail {
    private final UserRepository userRepository;

    @Autowired
    private JavaMailSender javaEmailSender;

    public boolean notifyAdmin(Author author){
        User admin = userRepository.findUserByRole("admin");
        if(admin==null) return false;
        String adminMail = admin.getEmail();

        String body = "a new Author has been register, please contact them.   contact info: "+author.getName()+" | "+author.getPhoneNumber()+" | "+author.getEmail()+" | Freelancer code: "+author.getFreelancerCode();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(adminMail);
        simpleMailMessage.setFrom("rewaya.website26@outlook.com");
        simpleMailMessage.setSubject("a New Task");
        simpleMailMessage.setText(body);
        javaEmailSender.send(simpleMailMessage);
        return true;

    }

    public void sendMeetingLink(String username, String email, Meeting meeting){

    String body = "Dear "+username+", this is the meeting link you requested to join of title: "+meeting.getTitle()+"."
     +" on date "+meeting.getStartDate()+" - "+meeting.getEndDate()+", LINK: [ "+meeting.getLinkURL()+" ] Please join in time";

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("rewaya.website26@outlook.com");
        simpleMailMessage.setSubject("Meeting Link :)");
        simpleMailMessage.setText(body);
        javaEmailSender.send(simpleMailMessage);

    }

}
