package com.oop442.project.service;

import com.oop442.project.entity.VendorAssessmentForm;

public interface VendorAssessmentFormService {

    Object createVendorAssessmentForm(String userEmail, Integer deadline);

    VendorAssessmentForm getVendorAssessmentForm(Long id);

    Object getVendorAllAssessmentForms();

    Object updateVendorAssessmentForm(VendorAssessmentForm vendorAssessmentForm);

    Object deleteVendorAssessmentForm(Long id);

    Object approveVendorAssessmentForm(Long id, String status);

}
