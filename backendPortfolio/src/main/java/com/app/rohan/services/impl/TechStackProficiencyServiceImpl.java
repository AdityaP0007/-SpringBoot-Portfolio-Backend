package com.app.rohan.services.impl;

import com.app.rohan.pojos.Projects;
import com.app.rohan.pojos.TechStackProficiency;
import com.app.rohan.repositories.TechStackProficiencyRepository;
import com.app.rohan.services.IProject;
import com.app.rohan.services.ITechStackProficiency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TechStackProficiencyServiceImpl implements ITechStackProficiency {

    @Autowired
    private TechStackProficiencyRepository techStackProficiencyRepository;

    @Autowired
    private IProject projectService;

    @Override
    public void addTechStackProficiency(TechStackProficiency techStackProficiency) {
        techStackProficiencyRepository.save(techStackProficiency);
    }

    @Override
    public void deleteTechStackProficiency(String technology) {
        TechStackProficiency techStackProficiency=techStackProficiencyRepository.findByTechnology(technology).orElseThrow(()-> new RuntimeException("The technology with name: "+ technology + " not found"));
        techStackProficiencyRepository.deleteById(techStackProficiency.getId());
    }

    @Override
    public List<TechStackProficiency> getAllTechStackProficiency() {
        return techStackProficiencyRepository.findAll();
    }

    @Override
    public void updateTechStackProficiency(int id, TechStackProficiency techStackProficiency) {
        TechStackProficiency techStackProficiencyLifted = techStackProficiencyRepository.findById(id).orElseThrow(()-> new RuntimeException("Tech proficiency with id "+ techStackProficiency.getTechnology() + " not found"));
        techStackProficiencyLifted.setTechnology(techStackProficiency.getTechnology());
        techStackProficiencyLifted.setPercentage(techStackProficiency.getPercentage());
    }

//    @Override
//    public List<Projects> getProjectDetailsByTechnology(String technology) {
//        List<Projects> projectsList = projectService.getAllProjects();
//
//        List<Projects> projectsToFrontEnd = new ArrayList<>();
//
//        for(int i=0; i<projectsList.size(); i++){
//            projectsList.get(i).get
//        }
//
//
//
//    }


}
