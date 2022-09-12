package com.app.rohan.controllers;


import com.app.rohan.pojos.User;
import com.app.rohan.services.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IUser userService;

    @GetMapping("/hello")
    public String helloAdmin(){
        return "Hello Admin";
    }

    @RequestMapping("/update_email_id")
    public ResponseEntity<?> updateEmailId(String olderEmail, String newEmail) {
        User user = userService.updateEmailId(olderEmail, newEmail);
        return new ResponseEntity<>("Email ID updated successfully", HttpStatus.OK);
    }

    @RequestMapping("/update_name")
    public ResponseEntity<?> updateName(String olderEmail, String name) {
        User user = userService.updateName(olderEmail, name);
        return new ResponseEntity<>("Name updated successfully", HttpStatus.OK);
    }

    @RequestMapping("/update_password")
    public ResponseEntity<?> updatePassword(String olderEmail, String password) {
        User user = userService.updatePassword(olderEmail, password);
        return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
    }
}
