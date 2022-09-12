package com.app.rohan.services;

import com.app.rohan.dto.EducationOrCertificateDto;

import java.util.List;

public interface IEducationOrCertificate {

    public void addEduOrCert(EducationOrCertificateDto educationOrCertificateDto);

    public List<EducationOrCertificateDto> getAllEduOrCert();

    public void deleteEduOrCertById(int id);
}
