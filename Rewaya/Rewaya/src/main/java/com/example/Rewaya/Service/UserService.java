package com.example.Rewaya.Service;

import com.example.Rewaya.Model.User;
import com.example.Rewaya.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService{
private final UserRepository userRepository;

//CRUD]=================================================================== (0w0)

    public void addUser(User user){
        user.setPassword(hashPass(user.getPassword()));
        user.setRegisterDate(LocalDate.now());
        if(user.getPfpURL()==null) user.setPfpURL("resource/mystery_user.jpeg"); //if user didn't upload pfp
        userRepository.save(user);}


    public List<User> getAll(){ return userRepository.findAll();}

    public boolean updateUser(Integer id,User newInfo){

        User user = userRepository.findUserById(id);
        if(user==null) return false;

        user.setName(newInfo.getName());
        user.setUsername(newInfo.getUsername());
        user.setEmail(newInfo.getEmail());
        user.setPassword(hashPass(newInfo.getPassword()));
        user.setAge(newInfo.getAge());
        user.setRole(newInfo.getRole());

        userRepository.save(user);
        return true;

    }

    public boolean deleteUser(Integer id){

        User user = userRepository.findUserById(id);
        if(user==null) return false;

        userRepository.delete(user);
        return true;
    }



//========================================================================= extra E.P. =====(0-0)

    public String hashPass(String password){
        try {
            //this method return the password as hashed for security database :)
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            return password;
        }
    }

    public User logIn(String[] info){}

    //public boolean addTiptoFav()
}
