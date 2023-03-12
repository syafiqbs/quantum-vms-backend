package com.oop442.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("PreEvaluationForm")
public class PreEvaluationForm extends Form{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "preEvaluationForm")
    @JsonBackReference
    private User user;

    private String preEvaluationResults;

    public PreEvaluationForm() {
        super(null, null);
        this.preEvaluationResults = "false";
    }

    @Builder(builderMethodName = "preEvaluationFormBuilder")
    public PreEvaluationForm(String companyName, String companyAddress, String preEvaluationResults) {
        super(companyName, companyAddress);
        this.preEvaluationResults = preEvaluationResults;
    }
    
}
