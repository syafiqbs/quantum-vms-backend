package com.oop442.project.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@DiscriminatorValue("VendorAssessmentForm")
public class VendorAssessmentForm extends Form{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "vendorAssessmentForm")
    private User user;

    private String vendorAssessmentResults;

    @Builder(builderMethodName = "vendorAssessmentFormBuilder")
    public VendorAssessmentForm(String companyName, String companyAddress, String vendorAssessmentResults) {
        super(companyName, companyAddress);
        this.vendorAssessmentResults = vendorAssessmentResults;
    }

}
