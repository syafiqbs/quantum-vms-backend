package com.oop442.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("PerformanceEvaluationForm")
@Builder
public class PerformanceEvaluationForm extends Form{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne(mappedBy = "performanceEvaluationForm")
    @JsonBackReference
    private User user;

    private String performanceEvaluationResults;

    public PerformanceEvaluationForm() {
        super(null, null);
        this.performanceEvaluationResults = "false";
    }

    @Builder(builderMethodName = "performanceEvaluationFormBuilder")
    public PerformanceEvaluationForm(String companyName, String companyAddress, String performanceEvaluationResults) {
        super(companyName, companyAddress);
        this.performanceEvaluationResults = performanceEvaluationResults;
    }
}
