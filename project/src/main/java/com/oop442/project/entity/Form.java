package com.oop442.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@MappedSuperclass
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "form_type", discriminatorType = DiscriminatorType.STRING)
@AllArgsConstructor
public class Form {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String companyAddress;

    public Form(String companyName2, String companyAddress2) {
        this.companyName = companyName2;
        this.companyAddress = companyAddress2;
    }
}
