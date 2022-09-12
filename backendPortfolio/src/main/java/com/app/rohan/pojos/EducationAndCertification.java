package com.app.rohan.pojos;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "education_and_certification")
@Setter
@Getter
public class EducationAndCertification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private LocalDate startDate;

    private LocalDate endDate;

    @Column(name = "college_name_or_place")
    private String collegeNameOrPlace;


    @OneToMany(mappedBy = "educationAndCertification", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List <EducationalOrCertificationDetails> details = new ArrayList<>();

    public EducationAndCertification() {
    }

    public EducationAndCertification(String title, LocalDate startDate, LocalDate endDate, String collegeNameOrPlace) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.collegeNameOrPlace = collegeNameOrPlace;
    }

    public EducationAndCertification(Integer id, String title, LocalDate startDate, LocalDate endDate, String collegeNameOrPlace, List<EducationalOrCertificationDetails> details) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.collegeNameOrPlace = collegeNameOrPlace;
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getCollegeNameOrPlace() {
        return collegeNameOrPlace;
    }

    public List<EducationalOrCertificationDetails> getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "EducationAndCertification{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", collegeNameOrPlace='" + collegeNameOrPlace + '\'' +
                '}';
    }

    /**
     * HELPER METHODS
     */

    public void addEducationalOrCertificationDetails(EducationalOrCertificationDetails educationalOrCertificationDetails){
        this.details.add(educationalOrCertificationDetails);
        educationalOrCertificationDetails.setEducationAndCertification(this);
    }

    public void removeEducationalOrCertificationDetails(EducationalOrCertificationDetails educationalOrCertificationDetails){
        this.details.remove(educationalOrCertificationDetails);
        educationalOrCertificationDetails.setEducationAndCertification(null);
    }

}
