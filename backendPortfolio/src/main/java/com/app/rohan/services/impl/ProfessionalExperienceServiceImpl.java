package com.app.rohan.services.impl;

import com.app.rohan.dto.ProfessionalExperienceDto;
import com.app.rohan.pojos.ProfessionalExperience;
import com.app.rohan.pojos.Technology;
import com.app.rohan.repositories.ProfessionalExperienceRepository;
import com.app.rohan.services.IProfessionExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ProfessionalExperienceServiceImpl implements IProfessionExperience {

    @Autowired
    private ProfessionalExperienceRepository professionalExperienceRepository;

    @Override
    public void addProfessionalExperience(ProfessionalExperienceDto professionalExperienceDto) {

        ProfessionalExperience professionalExperience = new ProfessionalExperience(
                professionalExperienceDto.getTitle(),
                professionalExperienceDto.getStartDate(),
                professionalExperienceDto.getEndDate(),
                professionalExperienceDto.getCompanyName()
        );

        professionalExperienceRepository.save(professionalExperience);

        if (professionalExperienceDto.getTechnology().size() == 0) {
            System.out.println("No Technology details found");
            return;
        }

        for (int i = 0; i < professionalExperienceDto.getTechnology().size(); i++) {
            Technology technology = new Technology(professionalExperienceDto.getTechnology().get(i));
            professionalExperience.addTechnology(technology);
        }

    }

    @Override
    public void deleteProfessionalExperience(int id) {
        professionalExperienceRepository.deleteById(id);
    }

    @Override
    public List<ProfessionalExperience> getAllProfessionalExperience() {
        List<ProfessionalExperience> professionalExperienceList = professionalExperienceRepository.findAll();
        return professionalExperienceList;
    }

    @Override
    public ProfessionalExperience updateProfessionalExperience(ProfessionalExperienceDto professionalExperienceDto, int id) {
        ProfessionalExperience professionalExperience = professionalExperienceRepository.findById(id).orElseThrow(() -> new RuntimeException("Professional Experience with id " + id + " not found"));

        if (!(professionalExperience.getTitle().equals(professionalExperienceDto.getTitle()))) {
            professionalExperience.setTitle(professionalExperienceDto.getTitle());
        }

        if (!(professionalExperience.getStartDate().equals(professionalExperienceDto.getStartDate()))) {
            professionalExperience.setStartDate(professionalExperienceDto.getStartDate());
        }

        if (!(professionalExperience.getEndDate().equals(professionalExperienceDto.getEndDate()))) {
            professionalExperience.setEndDate(professionalExperienceDto.getEndDate());
        }

        if (!(professionalExperience.getCompanyName().equals(professionalExperienceDto.getCompanyName()))) {
            professionalExperience.setCompanyName(professionalExperienceDto.getCompanyName());
        }
        return professionalExperience;


    }
}
