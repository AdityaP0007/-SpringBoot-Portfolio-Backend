package com.app.rohan.pojos;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "technology_list")
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "tech_details")
    private String techDetails;

    @ManyToOne
    @JoinColumn(name = "pe_id")
    private ProfessionalExperience professionalExperience;

    @ManyToMany
    @JoinTable(
            name = "project_technology",
            joinColumns = @JoinColumn(name = "technology_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Projects> projectsSet = new HashSet<>();

    public Technology() {
    }

    public Technology(String techDetails) {
        this.techDetails = techDetails;
    }

    public String getTechDetails() {
        return techDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProfessionalExperience getProfessionalExperience() {
        return professionalExperience;
    }

    public void setProfessionalExperience(ProfessionalExperience professionalExperience) {
        this.professionalExperience = professionalExperience;
    }


}
