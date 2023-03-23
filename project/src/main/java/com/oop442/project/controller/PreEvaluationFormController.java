package com.oop442.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oop442.project.entity.PreEvaluationForm;
import com.oop442.project.entity.User;
import com.oop442.project.service.PreEvaluationFormService;

@RestController
@RequestMapping("/api/v1/vendor")
@CrossOrigin(origins = "*")
public class PreEvaluationFormController {

    @Autowired
    private PreEvaluationFormService preEvaluationFormService;

    @PostMapping("/createPreEvaluationForm")
    public ResponseEntity<Object> createPreEvaluationForm(@RequestBody User user) {
        return ResponseEntity.ok(preEvaluationFormService.createPreEvaluationForm(user.getEmail()));
    }

    @PostMapping("/getPreEvaluationForm")
    public ResponseEntity<Object> getPreEvaluationForm(@RequestBody PreEvaluationForm preEvaluationForm) {
        return ResponseEntity.ok(preEvaluationFormService.getPreEvaluationForm(preEvaluationForm.getId()));
    }

    @GetMapping("/getAllPreEvaluationForms")
    public ResponseEntity<Object> getAllPreEvaluationForms() {
        return ResponseEntity.ok(preEvaluationFormService.getAllPreEvaluationForms());
    }

    @PutMapping("/updatePreEvaluationForm")
    public ResponseEntity<Object> updatePreEvaluationForm(@RequestBody PreEvaluationForm preEvaluationForm) {
        return ResponseEntity.ok(preEvaluationFormService.updatePreEvaluationForm(preEvaluationForm));
    }

    @DeleteMapping("/deletePreEvaluationForm")
    public ResponseEntity<Object> deletePreEvaluationForm(@RequestBody PreEvaluationForm preEvaluationForm) {
        return ResponseEntity.ok(preEvaluationFormService.deletePreEvaluationForm(preEvaluationForm.getId()));
    }
}
