package com.app.rohan.controllers;


import com.app.rohan.pojos.Contact;
import com.app.rohan.services.IContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/contact")
public class ContactController {

    @Autowired
    private IContact contactService;

    @PostMapping("/add")
    public ResponseEntity<?> addContact(@RequestBody Contact contact){
        contactService.addContact(contact);
        return new ResponseEntity<>("Contact Added Successfully", HttpStatus.OK);
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<Contact>> getAllContactDetails(){
        List <Contact> contactList = contactService.getAllContactDetails();
        return new ResponseEntity<>(contactList, HttpStatus.OK);
    }


    @PostMapping("/get_by_email")
    public  ResponseEntity<?> getContactByEmailId(@RequestParam String email){
        return new ResponseEntity<>(contactService.getContactByEmailId(email), HttpStatus.OK);
    }
}
