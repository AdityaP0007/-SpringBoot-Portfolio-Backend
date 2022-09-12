package com.app.rohan.services.impl;

import com.app.rohan.dto.EducationOrCertificateDto;
import com.app.rohan.pojos.EducationAndCertification;
import com.app.rohan.pojos.EducationalOrCertificationDetails;
import com.app.rohan.repositories.EducationOrCertificateRepository;
import com.app.rohan.services.IEducationOrCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class EducationOrCertificateImpl implements IEducationOrCertificate {

    @Autowired
    private EducationOrCertificateRepository educationOrCertificateRepository;

    @Override
    public void addEduOrCert(EducationOrCertificateDto educationOrCertificateDto) {

        //        this.title = title;
        //        this.startDate = startDate;
        //        this.endDate = endDate;
        //        this.collegeNameOrPlace = collegeNameOrPlace;
        EducationAndCertification educationAndCertification
                = new EducationAndCertification(
                educationOrCertificateDto.getTitle(),
                educationOrCertificateDto.getStartDate(),
                educationOrCertificateDto.getEndDate(),
                educationOrCertificateDto.getCollegeNameOrPlace()
        );

        educationOrCertificateRepository.save(educationAndCertification);

        List<EducationalOrCertificationDetails> educationAndCertificationList = new ArrayList<>();
        for(int i=0; i<educationOrCertificateDto.getDetails().size(); i++){
            EducationalOrCertificationDetails educationalOrCertificationDetails = new
                    EducationalOrCertificationDetails(educationOrCertificateDto.getDetails().get(i));
            educationAndCertification.addEducationalOrCertificationDetails(educationalOrCertificationDetails);
        }

    }

    @Override
    public List<EducationOrCertificateDto> getAllEduOrCert() {
        List <EducationOrCertificateDto> listToFrontEnd = new ArrayList<>();

        List<EducationAndCertification> list = educationOrCertificateRepository.findAll();

        //    private Integer id;
        //    private String title;
        //    private LocalDate startDate;
        //    private LocalDate endDate;
        //    private String collegeNameOrPlace;
        //    List<String> details = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            EducationOrCertificateDto educationOrCertificateDto = new EducationOrCertificateDto(
                    list.get(i).getId(),
                    list.get(i).getTitle(),
                    list.get(i).getStartDate(),
                    list.get(i).getEndDate(),
                    list.get(i).getCollegeNameOrPlace(),
                    null
            );

            List <String> educationalOrCertificationDetailsList = new ArrayList<>();

            for(int j=0; j<list.get(i).getDetails().size(); j++){
                educationalOrCertificationDetailsList.add(list.get(i).getDetails().get(j).getEducationalOrCertificationDetails());
            }
            educationOrCertificateDto.setDetails(educationalOrCertificationDetailsList);

            listToFrontEnd.add(educationOrCertificateDto);

        }

        return listToFrontEnd;

    }

    @Override
    public void deleteEduOrCertById(int id) {
        educationOrCertificateRepository.deleteById(id);
    }
}
