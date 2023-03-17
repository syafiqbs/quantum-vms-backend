package com.oop442.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oop442.project.entity.PerformanceEvaluationForm;
import com.oop442.project.entity.PreEvaluationForm;
import com.oop442.project.entity.VendorAssessmentForm;
import com.oop442.project.service.PerformanceEvaluationFormService;
import com.oop442.project.service.PreEvaluationFormService;
import com.oop442.project.service.VendorAssessmentFormService;

@RestController
@RequestMapping("/api/v1/approver")
@CrossOrigin(origins = "*")
public class FormApproverController {

    @Autowired
    private PerformanceEvaluationFormService performanceEvaluationFormService;

    @Autowired
    private VendorAssessmentFormService vendorAssessmentFormService;

    @Autowired
    private PreEvaluationFormService preEvaluationFormService;


    @PostMapping("/approvePerformanceEvaluationForm/{id}")
    public Object approvePerformanceEvaluationForm(@PathVariable Long id, @RequestBody PerformanceEvaluationForm performanceEvaluationForm) {
        return performanceEvaluationFormService.approvePerformanceEvaluationForm(id, performanceEvaluationForm.getPerformanceEvaluationResults());
    }

    @PostMapping("/approveVendorAssessmentForm/{id}")
    public Object approveVendorAssessmentForm(@PathVariable Long id, @RequestBody VendorAssessmentForm vendorAssessmentForm) {
        return vendorAssessmentFormService.approveVendorAssessmentForm(id, vendorAssessmentForm.getVendorAssessmentResults());
    }
    
    
    @PostMapping("/approvePreEvaluationForm/{id}")
    public Object approvePreEvaluationForm(@PathVariable Long id, @RequestBody PreEvaluationForm preEvaluationForm) {
        return preEvaluationFormService.approvePreEvaluationForm(id, preEvaluationForm.getPreEvaluationResults());
    }

}
