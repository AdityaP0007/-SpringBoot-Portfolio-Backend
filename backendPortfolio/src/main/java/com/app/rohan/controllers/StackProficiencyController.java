package com.app.rohan.controllers;


import com.app.rohan.pojos.TechStackProficiency;
import com.app.rohan.services.ITechStackProficiency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/tech_stack_prof")
public class StackProficiencyController {

    @Autowired
    private ITechStackProficiency techStackProficiencyService;

    @PostMapping("/add")
    public ResponseEntity<?> addTechStackProficiency(@RequestBody TechStackProficiency techStackProficiency) {
        techStackProficiencyService.addTechStackProficiency(techStackProficiency);
        return new ResponseEntity<>("Tech Stack Proficiency added: " + techStackProficiency.getTechnology() + " with " + techStackProficiency.getPercentage(), HttpStatus.OK);
    }

    @PostMapping("/delete/{tech}")
    public ResponseEntity<?> deleteTechStackProficiency(@PathVariable String tech) {
        techStackProficiencyService.deleteTechStackProficiency(tech);
        return new ResponseEntity<>("The technology: " + tech + " is deleted successfully", HttpStatus.OK);

    }

    @PostMapping("/get_all")
    public ResponseEntity<?> getAllTechStackProficiency() {
        return new ResponseEntity<>(techStackProficiencyService.getAllTechStackProficiency(), HttpStatus.OK);
    }


    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateTechStackProficiency(@PathVariable int id, @RequestBody TechStackProficiency techStackProficiency) {
        techStackProficiencyService.updateTechStackProficiency(id, techStackProficiency);
        return new ResponseEntity<>("The technology: " + techStackProficiency.getTechnology() + " is updated successfully", HttpStatus.OK);

    }

//    @PostMapping("/get_project_details_by_tech")
//    public ResponseEntity<?> getProjectDetailsByTechnology(@PathVariable String technology){
//
//    }


}
