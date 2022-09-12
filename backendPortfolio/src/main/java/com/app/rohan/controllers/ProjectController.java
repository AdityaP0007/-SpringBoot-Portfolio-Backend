package com.app.rohan.controllers;


import com.app.rohan.pojos.Projects;
import com.app.rohan.services.IProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/project")
public class ProjectController {

//    @Autowired
//    private IProject projectService;
//
//    @PostMapping("/add")
//    public ResponseEntity<?> addProject(@RequestBody Projects projects){
//        projectService.addProject(projects);
//        return new ResponseEntity<>("Project added successfully", HttpStatus.OK);
//    }
//
//    @GetMapping("/get_all")
//    public ResponseEntity<?> getAllProjects(){
//        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
//    }
//
//    @PostMapping("delete/{id}")
//    public ResponseEntity<?> deleteProjectById(@PathVariable int id){
//        Projects project =projectService.deleteProjectById(id);
//        return new ResponseEntity<>("The project with project name: " +project.getProjectName() + " deleted successfully" , HttpStatus.OK);
//    }
//
//    @PostMapping("/update/{id}")
//    public ResponseEntity<?> updateProject(@PathVariable int id, @RequestBody Projects projects){
//        Projects project = projectService.updateProject(id, projects);
//        return new ResponseEntity<>("The project with project name: " +project.getProjectName() + " updated successfully" , HttpStatus.OK);
//    }
}
