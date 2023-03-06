package com.oop442.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oop442.project.entity.PerformanceEvaluationForm;
import com.oop442.project.service.PerformanceEvaluationFormService;

@RestController
@RequestMapping("/api/v1/vendor")
public class PerformanceEvaluationFormController {

    @Autowired
    private PerformanceEvaluationFormService performanceEvaluationFormService;

    @GetMapping("/getPerformanceEvaluationForm")
    public ResponseEntity<Object> getPerformanceEvaluationForm(@RequestBody PerformanceEvaluationForm performanceEvaluationForm) {
        return ResponseEntity.ok(performanceEvaluationFormService.getPerformanceEvaluationForm(performanceEvaluationForm.getId()));
    }

    @GetMapping("/getPerformanceAllEvaluationForms")
    public ResponseEntity<Object> getPerformanceAllEvaluationForms() {
        return ResponseEntity.ok(performanceEvaluationFormService.getPerformanceAllEvaluationForms());
    }
    
    @PutMapping("/updatePerformanceEvaluationForm")
    public ResponseEntity<Object> updatePerformanceEvaluationForm(@RequestBody PerformanceEvaluationForm performanceEvaluationForm) {
        return ResponseEntity.ok(performanceEvaluationFormService.updatePerformanceEvaluationForm(performanceEvaluationForm));
    }

    @DeleteMapping("/deletePerformanceEvaluationForm")
    public ResponseEntity<Object> deletePerformanceEvaluationForm(@RequestBody PerformanceEvaluationForm performanceEvaluationForm) {
        return ResponseEntity.ok(performanceEvaluationFormService.deletePerformanceEvaluationForm(performanceEvaluationForm.getId()));
    }
}
