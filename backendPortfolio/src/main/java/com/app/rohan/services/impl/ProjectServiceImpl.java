package com.app.rohan.services.impl;

import com.app.rohan.pojos.Projects;
import com.app.rohan.repositories.ProjectRepository;
import com.app.rohan.services.IProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements IProject {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void addProject(Projects projects) {
        projectRepository.save(projects);
    }

    @Override
    public List<Projects> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Projects deleteProjectById(int id) {
        Projects projects = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
        projectRepository.deleteById(id);
        return projects;

    }

    @Override
    public Projects updateProject(int id, Projects projects) {
        Projects projectLifted = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));

        if (!(projectLifted.getProjectName().equals(projects.getProjectName()))) {
            projectLifted.setProjectName(projects.getProjectName());
        }

        if (!(projectLifted.getProjectDescription().equals(projects.getProjectDescription()))) {
            projectLifted.setProjectDescription(projects.getProjectDescription());
        }

        if (!(projectLifted.getProjectLink().equals(projects.getProjectLink()))) {
            projectLifted.setProjectLink(projects.getProjectLink());
        }

        if (!(projectLifted.getTeamSize()== (projects.getTeamSize()))) {
            projectLifted.setTeamSize(projects.getTeamSize());
        }


        if (!(projectLifted.getProjectStatus().equals(projects.getProjectStatus()))) {
            projectLifted.setProjectStatus(projects.getProjectStatus());
        }

        if (!(projectLifted.getProjectType().equals(projects.getProjectType()))) {
            projectLifted.setProjectType(projects.getProjectType());
        }

        return projectLifted;
    }
}
