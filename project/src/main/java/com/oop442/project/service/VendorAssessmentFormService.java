package com.oop442.project.service;

import com.oop442.project.entity.VendorAssessmentForm;

public interface VendorAssessmentFormService {

    VendorAssessmentForm getVendorAssessmentForm(Long id);

    Object getVendorAllAssessmentForms();

    Object updateVendorAssessmentForm(VendorAssessmentForm vendorAssessmentForm);

    Object deleteVendorAssessmentForm(Long id);

}
