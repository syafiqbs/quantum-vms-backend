package com.oop442.project.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pre_evaluation_form")
public class PreEvaluationForm{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "preEvaluationForm")
    @JsonBackReference
    private User user;
    
    // Headers
    private String subContractorName;
    private String scopeOfWork;
    private String evaluationPerson;
    private String evaluationDate;

    // Safety & Health Policy and Organisation
    private String writtenPolicy;
    private String safetyOrganisation;
    private String safetyCommitment;

    //Tool Box Meeting
    private String toolBoxMeetings;

    //Safety Training
    private String mgmtTrainingCourse;
    private String workersTrainingCourse;
    private String trainingCertificates;

    //Safety & Health Rules & Safe Work Procedures/Risk Assessment
    private String writtenSafetyRules;
    private String writternRiskAssessment;

    //Safety & Health Inspection & Equipment
    private String inspectionGuidelines;
    private String ppe;

    //Responsible Personnel
    private String safetySupervisorWorkingHours;
    private String firstAider;
    private String qualifiedEngineers;

    //Accident Analysis
    private String temporaryDisabilityCases;
    private String permanentDisabilityCases;
    private String fatalityCases;

    //Acknowledgement
    private String acknowledgementPerson;
    private String acknowledgementDate;
    private String acknowledgementSignature;


    @Builder.Default
    private String preEvaluationResults = "Draft";
    
}
