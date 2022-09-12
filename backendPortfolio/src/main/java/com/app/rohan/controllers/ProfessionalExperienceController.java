package com.app.rohan.controllers;


import com.app.rohan.dto.ProfessionalExperienceDto;
import com.app.rohan.pojos.ProfessionalExperience;
import com.app.rohan.services.IProfessionExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user/professional_experience")
public class ProfessionalExperienceController {


    @Autowired
    private IProfessionExperience professionalExperienceService;


    //add experience
    @PostMapping("/add")
    public ResponseEntity<?> addProfessionalExperience(@RequestBody ProfessionalExperienceDto professionalExperienceDto) {
        professionalExperienceService.addProfessionalExperience(professionalExperienceDto);
        return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
    }


    //if you want to change the all the details except tech list details for that there is different api
    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateProfessionalExperience(@RequestBody ProfessionalExperienceDto professionalExperienceDto, @PathVariable int id) {
        System.out.println("Inside method");
        ProfessionalExperience professionalExperience = professionalExperienceService.updateProfessionalExperience(professionalExperienceDto, id);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);

    }

    //delete experience
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteProfessionalExperience(@PathVariable int id) {
        professionalExperienceService.deleteProfessionalExperience(id);
        return new ResponseEntity<>("Deleted Successfully: " + id, HttpStatus.OK);
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<ProfessionalExperienceDto>> getAllProfessionalExperience() {
        List<ProfessionalExperience> professionalExperienceList = professionalExperienceService.getAllProfessionalExperience();

        List<ProfessionalExperienceDto> professionalExperienceDtoList = new ArrayList<>();


        //    private String title;
        //
        //    private LocalDate startDate;
        //
        //    private LocalDate endDate;
        //
        //    private String companyName;
        for (int i = 0; i < professionalExperienceList.size(); i++) {
            ProfessionalExperienceDto professionalExperienceDto = new ProfessionalExperienceDto(
                    professionalExperienceList.get(i).getTitle(),
                    professionalExperienceList.get(i).getStartDate(),
                    professionalExperienceList.get(i).getEndDate(),
                    professionalExperienceList.get(i).getCompanyName(), null
            );

            List<String> technologyStringList = new ArrayList<>();

            for (int j = 0; j < professionalExperienceList.get(i).getTechnology().size(); j++) {
                technologyStringList.add(professionalExperienceList.get(i).getTechnology().get(j).getTechDetails());
            }
            professionalExperienceDto.setTechnology(technologyStringList);

            professionalExperienceDtoList.add(professionalExperienceDto);


        }

        return new ResponseEntity<>(professionalExperienceDtoList, HttpStatus.OK);


    }


}
