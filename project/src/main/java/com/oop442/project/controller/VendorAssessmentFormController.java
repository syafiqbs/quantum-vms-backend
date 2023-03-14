package com.oop442.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oop442.project.entity.VendorAssessmentForm;
import com.oop442.project.service.VendorAssessmentFormService;

@RestController
@RequestMapping("/api/v1/vendor")
@CrossOrigin(origins = "*")
public class VendorAssessmentFormController {
    
    @Autowired
    private VendorAssessmentFormService vendorAssessmentFormService;

    @GetMapping("/getVendorAssessmentForm")
    public ResponseEntity<Object> getVendorAssessmentForm(@RequestBody VendorAssessmentForm vendorAssessmentForm) {
        return ResponseEntity.ok(vendorAssessmentFormService.getVendorAssessmentForm(vendorAssessmentForm.getId()));
    }

    @GetMapping("/getVendorAllAssessmentForms")
    public ResponseEntity<Object> getVendorAllAssessmentForms() {
        return ResponseEntity.ok(vendorAssessmentFormService.getVendorAllAssessmentForms());
    }

    @PutMapping("/updateVendorAssessmentForm")
    public ResponseEntity<Object> updateVendorAssessmentForm(@RequestBody VendorAssessmentForm vendorAssessmentForm) {
        return ResponseEntity.ok(vendorAssessmentFormService.updateVendorAssessmentForm(vendorAssessmentForm));
    }

    // @DeleteMapping("/deleteVendorAssessmentForm")
    // public ResponseEntity<Object> deleteVendorAssessmentForm(@RequestBody VendorAssessmentForm vendorAssessmentForm) {
    //     return ResponseEntity.ok(vendorAssessmentFormService.deleteVendorAssessmentForm(vendorAssessmentForm.getId()));
    // }
}
