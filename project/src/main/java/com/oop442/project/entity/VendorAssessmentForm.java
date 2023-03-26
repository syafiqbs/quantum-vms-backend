package com.oop442.project.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "vendor_assessment_form")
public class VendorAssessmentForm{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    @JsonBackReference
    private User user;

    // Headers
    private String companyName;
    private String companyRegistrationNo;
    private String companyAddress;
    private String companyContactNo;

    //GST Registered
    private String gstRegistered;

    //Type of BUsiness License / Registration
    private String businessType;

    //Nature of Business
    private String businessNature;

    //Products and Services
    private String productsAndServices;

    //Contact Person
    private String contactPersonName1;
    private String contactPersonContactNo1;
    private String contactPersonDesignation1;
    private String contactPersonName2;
    private String contactPersonContactNo2;
    private String contactPersonDesignation2;

    //Evaluation
    private String evaluation;
    private String iso9001;
    private String accreditationLaboratory;
    private String projectCertification;
    private String siteEvaluationResults;
    private String sampleProductEvaluation;
    private String resultFirstDeal;
    private String trackRecord;
    private String others;

    //Vendor Assessment Results
    private String evaluatedBy;
    private String evaluatorSignature;
    private String approvedBy;
    private String approverSignature;
    private String effectiveDate;
    
    //Evaluation Results
    @Builder.Default
    private String vendorAssessmentResults = "Draft";
    private String evaluationComments;

    @Builder.Default
    private Date dateCreated = new Date();
    private String dateModified;
    private Date deadline;
}
