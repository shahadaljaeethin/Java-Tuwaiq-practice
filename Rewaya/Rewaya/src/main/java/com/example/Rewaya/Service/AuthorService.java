package com.example.Rewaya.Service;

import com.example.Rewaya.Model.Author;
import com.example.Rewaya.Repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    //---------------

    public void registerAuthor(Author author){

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

}
