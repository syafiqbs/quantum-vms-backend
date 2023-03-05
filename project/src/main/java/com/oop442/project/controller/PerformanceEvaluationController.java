package com.oop442.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oop442.project.entity.PerformanceEvaluationForm;
import com.oop442.project.entity.User;
import com.oop442.project.repository.PerformanceEvaluationFormRepository;
import com.oop442.project.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/vendor")
public class PerformanceEvaluationController {
    
    private PerformanceEvaluationFormRepository performanceEvaluationFormRepository;
    private UserRepository userRepository;

    public PerformanceEvaluationController(PerformanceEvaluationFormRepository performanceEvaluationFormRepository) {
        this.performanceEvaluationFormRepository = performanceEvaluationFormRepository;
    }

    @PostMapping("/createPerformanceEvaluationForm")
    public ResponseEntity<Object> createPerformanceEvaluation(@RequestBody User user) {
        User vendor = userRepository.findByEmail(user.getEmail()).get();
        if (vendor == null) {
            return ResponseEntity.badRequest().body("Vendor not found");
        }
        PerformanceEvaluationForm performanceEvaluationForm = new PerformanceEvaluationForm();
        performanceEvaluationForm.setVendor(vendor);
        
        return ResponseEntity.ok(performanceEvaluationFormRepository.save(performanceEvaluationForm));
    }

    @PostMapping("/updatePerformanceEvaluationForm")
    public ResponseEntity<Object> updatePerformanceEvaluationForm(@RequestBody PerformanceEvaluationForm performanceEvaluationForm) {
        PerformanceEvaluationForm performanceEvaluationFormToUpdate = performanceEvaluationFormRepository.findById(performanceEvaluationForm.getId()).get();
        if (performanceEvaluationFormToUpdate == null) {
            return ResponseEntity.badRequest().body("Performance Evaluation Form not found");
        }
        performanceEvaluationFormToUpdate.setName(performanceEvaluationForm.getName());
        performanceEvaluationFormToUpdate.setDescription(performanceEvaluationForm.getDescription());
        performanceEvaluationFormToUpdate.setForm(performanceEvaluationForm.getForm());
        performanceEvaluationFormToUpdate.setFormType(performanceEvaluationForm.getFormType());
        performanceEvaluationFormToUpdate.setFormStatus(performanceEvaluationForm.getFormStatus());
        performanceEvaluationFormToUpdate.setFormDate(performanceEvaluationForm.getFormDate());
        performanceEvaluationFormToUpdate.setFormTime(performanceEvaluationForm.getFormTime());
        performanceEvaluationFormToUpdate.setFormLocation(performanceEvaluationForm.getFormLocation());
        performanceEvaluationFormToUpdate.setFormLink(performanceEvaluationForm.getFormLink());
        performanceEvaluationFormToUpdate.setFormLinkText(performanceEvaluationForm.getFormLinkText());

        return ResponseEntity.ok(performanceEvaluationFormRepository.save(performanceEvaluationForm));
    }

    @GetMapping("/getPerformanceEvaluationForm")
    public ResponseEntity<Object> getPerformanceEvaluationForm(@RequestBody PerformanceEvaluationForm performanceEvaluationForm) {
        return ResponseEntity.ok(performanceEvaluationFormRepository.findById(performanceEvaluationForm.getId()));
    }
}
