package com.example.Rewaya.Service;

import com.example.Rewaya.Model.Author;
import com.example.Rewaya.Model.User;
import com.example.Rewaya.Repository.AuthorRepository;
import com.example.Rewaya.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final UserRepository userRepository;

    //---------------

    public void registerAuthor(Author author){

        if(author.getPfpURL()==null) author.setPfpURL("resource/mystery_author.jpeg");
        author.setActive(false);
        author.setRegisterDate(LocalDate.now());
        author.setPassword(hashPass(author.getPassword())); //hash pass
        authorRepository.save(author);
        //notify admin ?

    }

    public List<Author> getAll(){return authorRepository.findAll();}


    public String updateAuthor(Integer id,Author upd){
    Author author = authorRepository.findAuthorById(id);
    if(author==null) return "Author not found";

   // if(!author.getActive()) return "Author is not approved yet";
        //maybe author needs to update their contact info even when they are inactive

    author.setName(upd.getName());
    author.setUsername(upd.getUsername());
    author.setEmail(upd.getEmail());
    author.setPassword(hashPass(upd.getPassword())); //hash
    author.setFreelancerCode(upd.getFreelancerCode());
    author.setPhoneNumber(upd.getPhoneNumber());

    authorRepository.save(author);
    return "updated";
    }

    public boolean deleteAuthor(Integer id){
        Author author = authorRepository.findAuthorById(id);
        if(author==null) return false;
        authorRepository.delete(author);
        return true;
    }




//=========================== END OF CRUD AAH===============================================

    //( service method to hash passwords )

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

    //E.E.P    Activate or even freeze an author
    public String setAccountStatus(boolean status,Integer admin,Integer authorId){

        Author auth = authorRepository.findAuthorById(authorId);
        if(auth==null) return "author not found";

        User user = userRepository.findUserById(admin);
        if(user==null) return "admin not found";
        if(!user.getRole().equals("admin")) return "role not allowed to do this operation!";

        if(auth.getActive()==status) return "the author already has this status";

        auth.setActive(status);
        String message = (status) ? "Account Activated! :)" : "Account froze successfully";
        return message;

    }

}
