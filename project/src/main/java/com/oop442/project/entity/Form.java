package com.oop442.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@MappedSuperclass
@DiscriminatorColumn(name = "form_type", discriminatorType = DiscriminatorType.STRING)
public class Form {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String companyName;
    private String companyAddress;

    public Form(String companyName2, String companyAddress2) {
        this.companyName = companyName2;
        this.companyAddress = companyAddress2;
    }
}
