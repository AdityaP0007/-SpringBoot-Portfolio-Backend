package com.app.rohan.controllers;


import com.app.rohan.dto.EducationOrCertificateDto;
import com.app.rohan.services.IEducationOrCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/edu_and_cert")
public class EducationAndCertificationController {

    @Autowired
    private IEducationOrCertificate educationOrCertificateService;


    @PostMapping("/add")
    public ResponseEntity<?> addEduOrCert(@RequestBody EducationOrCertificateDto educationOrCertificateDto){
        educationOrCertificateService.addEduOrCert(educationOrCertificateDto);
        return new ResponseEntity<>("Education or Certificate added successfully", HttpStatus.OK);
    }

    @GetMapping("/get_all")
    public ResponseEntity<?> getAllEduOrCert(){
        return new ResponseEntity<>(educationOrCertificateService.getAllEduOrCert(), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteEduOrCertById(@PathVariable int id){
        educationOrCertificateService.deleteEduOrCertById(id);
        return new ResponseEntity<>("Education or Certificate deleted successfully with id: "+ id, HttpStatus.OK);
    }

}
