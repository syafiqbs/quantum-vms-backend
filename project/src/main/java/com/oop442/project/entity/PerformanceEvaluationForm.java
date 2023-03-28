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
@Table(name = "performance_evaluation_form")
public class PerformanceEvaluationForm{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    @JsonBackReference
    private User user;

    // Headers
    private String contractorName;
    private String trade;
    private String projectWorksite;
    private String date;

    // Part I: Participation in Safety
    private String attendanceSafetyMeeting;
    private String toolBoxMeeting;
    private String complianceRulesAndRegulation;
    private String safetyPromotionalActivities;
    private String documentSubmission;
    private String partOneScore;

    // Part II: Safety Training and Competencies (% of attendance)
    private String safetyTraining;
    private String safetyTrade;
    private String safetyTalk;
    private String wshSafetyCoordinator;
    private String otherSafetyTraining;
    private String partTwoScore;

    // Part III: Accident/Incident Preview
    private String accidentPrevention;
    private String safeWorkPractice;
    private String incidentSeverity;
    private String safetyOffense;
    private String safetyInspection;
    private String partThreeScore;

    // Part IV: Maintenance of Equipment
    private String explosivePoweredTool;
    private String ladder;
    private String liftingGear;
    private String electricalEquipment;
    private String otherMachineries;
    private String partFourScore;

    // Part V: General Housekeeping & Others
    private String subconSnrMgmt;
    private String compliancePPE;
    private String sitehouseKeepingCleanliness;
    private String storehouseKeepingCleanliness;
    private String quarterhouseKeepingCleanliness;
    private String partFiveScore;
    
    //Performance Evaluator & Approver
    private String evaluatedBy;
    private String evaluatorSignature;
    private String dateEvaluated;
    private String approvedBy;
    private String approverSignature;
    private String dateApproved;

    //footer
    private String comments;
    private String totalScore;
    private String overallPerformanceStandard;

    //Evaluation 
    @Builder.Default
    private String performanceEvaluationResults = "Draft";
    private String evaluationComments;

    //Date
    @Builder.Default
    private Date dateCreated = new Date();
    private String dateModified;
    private Date deadline;
}
