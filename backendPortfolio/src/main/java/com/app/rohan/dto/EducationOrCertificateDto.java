package com.app.rohan.dto;

import com.app.rohan.pojos.EducationalOrCertificationDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationOrCertificateDto {

    private Integer id;
    private String title;

    private LocalDate startDate;

    private LocalDate endDate;

    private String collegeNameOrPlace;

    List<String> details = new ArrayList<>();

    public EducationOrCertificateDto(String title, LocalDate startDate, LocalDate endDate, String collegeNameOrPlace, List<String> details) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.collegeNameOrPlace = collegeNameOrPlace;
        this.details = details;
    }
}
