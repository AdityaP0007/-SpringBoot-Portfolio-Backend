package com.app.rohan.dto;

import com.app.rohan.pojos.Technology;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionalExperienceDto {

    private String title;

    private LocalDate startDate;

    private LocalDate endDate;

    private String companyName;

    List<String> technology = new ArrayList<>();

}
