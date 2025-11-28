package com.example.Rewaya.Controller;

import com.example.Rewaya.Api.ApiResponse;
import com.example.Rewaya.Model.User;
import com.example.Rewaya.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rewaya/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> registerUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()) return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){return ResponseEntity.status(200).body(userService.getAll());}

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id,@RequestBody @Valid User upd,Errors errors){
        if(errors.hasErrors()) return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());


        if(userService.updateUser(id, upd))
            return ResponseEntity.status(200).body(new ApiResponse("updated"));
        return ResponseEntity.status(400).body(new ApiResponse("user not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){

        if(userService.deleteUser(id))
            return ResponseEntity.status(200).body(new ApiResponse("deleted"));
        return ResponseEntity.status(400).body(new ApiResponse("User not found"));
    }

    //============================================

    @GetMapping("/log in")
    public ResponseEntity<?> logIn(@RequestBody String[] info){
        User user = userService.logIn(info);
        if(user!=null)
            return ResponseEntity.status(200).body(new ApiResponse("logged in successfully to "+user.getUsername()));
        return ResponseEntity.status(400).body(new ApiResponse("wrong username or password"));
    }
}
