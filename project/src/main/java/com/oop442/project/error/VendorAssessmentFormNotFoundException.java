package com.oop442.project.error;

public class VendorAssessmentFormNotFoundException extends RuntimeException{

    public VendorAssessmentFormNotFoundException(Long id) {
        super("VendorAssessmentForm not found with id: " + id);
    }

}
