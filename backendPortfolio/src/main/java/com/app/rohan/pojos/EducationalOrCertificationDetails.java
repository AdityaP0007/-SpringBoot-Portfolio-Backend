package com.app.rohan.pojos;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "educational_more_details")
@Setter
@Getter
public class EducationalOrCertificationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "edu_details")
    private String educationalOrCertificationDetails;

    @ManyToOne
    @JoinColumn(name = "eac_id")
    private EducationAndCertification educationAndCertification;

    public EducationalOrCertificationDetails() {
    }

    public EducationalOrCertificationDetails(String educationalOrCertificationDetails) {
        this.educationalOrCertificationDetails = educationalOrCertificationDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EducationAndCertification getEducationAndCertification() {
        return educationAndCertification;
    }

    public void setEducationAndCertification(EducationAndCertification educationAndCertification) {
        this.educationAndCertification = educationAndCertification;
    }
}
