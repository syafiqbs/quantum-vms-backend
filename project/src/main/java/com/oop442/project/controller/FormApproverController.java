package com.oop442.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oop442.project.service.PerformanceEvaluationFormService;
import com.oop442.project.service.PreEvaluationFormService;
import com.oop442.project.service.VendorAssessmentFormService;

@RestController
@RequestMapping("/api/v1/approver")
public class FormApproverController {

    @Autowired
    private PerformanceEvaluationFormService performanceEvaluationFormService;

    @Autowired
    private VendorAssessmentFormService vendorAssessmentFormService;

    @Autowired
    private PreEvaluationFormService preEvaluationFormService;

    @PostMapping("/approvePerformanceEvaluationForm")
    public Object approvePerformanceEvaluationForm(Long id) {
        return performanceEvaluationFormService.approvePerformanceEvaluationForm(id);
    }

    @PostMapping("/approveVendorAssessmentForm")
    public Object approveVendorAssessmentForm(Long id) {
        return vendorAssessmentFormService.approveVendorAssessmentForm(id);
    }

    @PostMapping("/approvePreEvaluationForm")
    public Object approvePreEvaluationForm(Long id) {
        return preEvaluationFormService.approvePreEvaluationForm(id);
    }

}
