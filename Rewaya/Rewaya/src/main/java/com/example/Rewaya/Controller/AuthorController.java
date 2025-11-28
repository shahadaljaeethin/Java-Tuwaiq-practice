package com.example.Rewaya.Controller;

import com.example.Rewaya.Api.ApiResponse;
import com.example.Rewaya.Model.Author;
import com.example.Rewaya.Service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/author")
public class AuthorController {
    private final AuthorService authorService;
//------


    @PostMapping("/register")
    public ResponseEntity<?> registerAuthor(@RequestBody @Valid Author author, Errors errors){
        if(errors.hasErrors()) return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        authorService.registerAuthor(author);
        return ResponseEntity.status(200).body(new ApiResponse("registered successfully, wait for the admin to response"));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){return ResponseEntity.status(200).body(authorService.getAll());}

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Integer id,@RequestBody @Valid Author upd, Errors errors){
        if(errors.hasErrors()) return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));


        String result = authorService.updateAuthor(id, upd);
        if(result.equals("updated")) return ResponseEntity.status(200).body(new ApiResponse(result));

        return ResponseEntity.status(400).body(new ApiResponse(result));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id){

        if(authorService.deleteAuthor(id))
         return ResponseEntity.status(200).body(new ApiResponse("Author deleted"));
        return ResponseEntity.status(400).body(new ApiResponse("Author not found :("));
    }
    //==============================

}
