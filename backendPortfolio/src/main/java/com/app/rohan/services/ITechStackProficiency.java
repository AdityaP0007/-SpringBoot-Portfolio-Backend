package com.app.rohan.services;

import com.app.rohan.pojos.Projects;
import com.app.rohan.pojos.TechStackProficiency;

import java.util.List;

public interface ITechStackProficiency {
    public void addTechStackProficiency(TechStackProficiency techStackProficiency);

    public void deleteTechStackProficiency(String technology);

    public List<TechStackProficiency> getAllTechStackProficiency();

    public void updateTechStackProficiency(int id, TechStackProficiency techStackProficiency);

//    public List<Projects> getProjectDetailsByTechnology(String technology);
}
