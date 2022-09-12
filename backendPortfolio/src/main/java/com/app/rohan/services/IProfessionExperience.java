package com.app.rohan.services;

import com.app.rohan.dto.ProfessionalExperienceDto;
import com.app.rohan.pojos.ProfessionalExperience;

import java.util.List;

public interface IProfessionExperience {
    public void addProfessionalExperience(ProfessionalExperienceDto professionalExperienceDto);

    public void deleteProfessionalExperience(int id);

    public List<ProfessionalExperience> getAllProfessionalExperience();

    public ProfessionalExperience updateProfessionalExperience(ProfessionalExperienceDto professionalExperienceDto, int id);
}
