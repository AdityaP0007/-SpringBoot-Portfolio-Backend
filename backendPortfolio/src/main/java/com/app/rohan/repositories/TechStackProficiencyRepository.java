package com.app.rohan.repositories;

import com.app.rohan.pojos.TechStackProficiency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechStackProficiencyRepository extends JpaRepository<TechStackProficiency, Integer> {
    Optional<TechStackProficiency> findByTechnology(String technology);
}
