package com.oop442.project.entity;

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
    
    @OneToOne(mappedBy = "performanceEvaluationForm")
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

    //footer
    private String comments;
    private String totalScore;

    @Builder.Default
    private String performanceEvaluationResults = "Draft";
}
