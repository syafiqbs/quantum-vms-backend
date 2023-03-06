package com.oop442.project.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("PerformanceEvaluationForm")
public class PerformanceEvaluationForm extends Form{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne(mappedBy = "performanceEvaluationForm")
    private User user;

    private String performanceEvaluationResults;

    @Builder(builderMethodName = "performanceEvaluationFormBuilder")
    public PerformanceEvaluationForm(String companyName, String companyAddress, String performanceEvaluationResults) {
        super(companyName, companyAddress);
        this.performanceEvaluationResults = performanceEvaluationResults;
    }
}
