package com.oop442.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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

    @CrossOrigin("*")
    @PostMapping("/approvePerformanceEvaluationForm/{id}")
    public Object approvePerformanceEvaluationForm(@PathVariable Long id) {
        return performanceEvaluationFormService.approvePerformanceEvaluationForm(id);
    }

    @CrossOrigin("*")
    @PostMapping("/approveVendorAssessmentForm/{id}")
    public Object approveVendorAssessmentForm(@PathVariable Long id) {
        return vendorAssessmentFormService.approveVendorAssessmentForm(id);
    }

    @CrossOrigin("*")
    @PostMapping("/approvePreEvaluationForm/{id}")
    public Object approvePreEvaluationForm(@PathVariable Long id) {
        return preEvaluationFormService.approvePreEvaluationForm(id);
    }

}
