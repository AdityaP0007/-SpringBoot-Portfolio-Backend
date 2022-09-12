package com.app.rohan.pojos;


import com.app.rohan.pojos.enums.ProjectStatus;
import com.app.rohan.pojos.enums.ProjectType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_link")
    private String projectLink;

    @Column(name = "project_description")
    private String projectDescription;

    @Column(name = "team_size")
    private int teamSize;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_status")
    private ProjectStatus projectStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_type")
    private ProjectType projectType;


    @ManyToMany(mappedBy = "projectsSet")
    private Set<Technology> technologySet = new HashSet<>();

    public Projects(String projectName, String projectLink, String projectDescription, int teamSize, ProjectStatus projectStatus, ProjectType projectType) {
        this.projectName = projectName;
        this.projectLink = projectLink;
        this.projectDescription = projectDescription;
        this.teamSize = teamSize;
        this.projectStatus = projectStatus;
        this.projectType = projectType;
    }
}
