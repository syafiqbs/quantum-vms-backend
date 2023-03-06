package com.oop442.project.entity;

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
    private User user;

    private String preEvaluationResults;

    @Builder(builderMethodName = "preEvaluationFormBuilder")
    public PreEvaluationForm(String companyName, String companyAddress, String preEvaluationResults) {
        super(companyName, companyAddress);
        this.preEvaluationResults = preEvaluationResults;
    }
    
}
