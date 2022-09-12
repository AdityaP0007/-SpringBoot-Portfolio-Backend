package com.app.rohan.pojos;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professional_experience")
public class ProfessionalExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private LocalDate startDate;

    private LocalDate endDate;

    @Column(name = "company_name")
    private String companyName;

    @OneToMany(mappedBy = "professionalExperience", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List <Technology> technology = new ArrayList<>();


    //###############################################################

    /**
     * HELPER METHODS- 2 WAY BINDING
     */

    public void addTechnology(Technology tech){
        this.technology.add(tech);
        tech.setProfessionalExperience(this);
    }

    public void removeTechnology(Technology tech){
        this.technology.remove(tech);
        tech.setProfessionalExperience(null);
    }

    //###############################################################


    public ProfessionalExperience() {
    }

    public ProfessionalExperience(String title, LocalDate startDate, LocalDate endDate, String companyName) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.companyName = companyName;
    }

    public ProfessionalExperience(Integer id, String title, LocalDate startDate, LocalDate endDate, String companyName, List<Technology> technology) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.companyName = companyName;
        this.technology = technology;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Technology> getTechnology() {
        return technology;
    }

    public void setTechnology(List<Technology> technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "ProfessionalExperience{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
