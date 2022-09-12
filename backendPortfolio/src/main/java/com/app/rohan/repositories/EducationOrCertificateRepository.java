package com.app.rohan.repositories;

import com.app.rohan.pojos.EducationAndCertification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationOrCertificateRepository extends JpaRepository<EducationAndCertification, Integer> {
}
