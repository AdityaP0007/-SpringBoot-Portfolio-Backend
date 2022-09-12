package com.app.rohan.repositories;

import com.app.rohan.pojos.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Projects, Integer> {
}
