package com.app.rohan.services;

import com.app.rohan.pojos.Projects;

import java.util.List;

public interface IProject {
    public void addProject(Projects projects);

    public List<Projects> getAllProjects();

    public Projects deleteProjectById(int id);

    public Projects updateProject(int id, Projects projects);

}
