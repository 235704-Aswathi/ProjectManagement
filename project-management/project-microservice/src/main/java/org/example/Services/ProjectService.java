package org.example.Services;

import org.example.domain.Project;

import java.util.Optional;

public interface ProjectService {

    Project addProject(Project project);

    Optional<Project> getProject(Project project);

    void deleteProjectById(String id);


    Optional<Project> getProjectById(String id);
}
