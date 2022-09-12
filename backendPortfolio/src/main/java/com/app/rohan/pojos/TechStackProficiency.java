package com.app.rohan.pojos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tech_stack_proficiency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TechStackProficiency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String technology;

    private int percentage;

    public TechStackProficiency(String technology, int percentage) {
        this.technology = technology;
        this.percentage = percentage;
    }
}
