package com.oop442.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oop442.project.entity.User;
import com.oop442.project.entity.VendorAssessmentForm;
import com.oop442.project.repository.UserRepository;
import com.oop442.project.repository.VendorAssessmentFormRepository;

@RestController
@RequestMapping("/api/v1/vendor")
public class VendorAssessmentController {

    private VendorAssessmentFormRepository vendorAssessmentFormRepository;
    private UserRepository userRepository;

    public VendorAssessmentController(VendorAssessmentFormRepository vendorAssessmentFormRepository) {
        this.vendorAssessmentFormRepository = vendorAssessmentFormRepository;
    }

    // @PostMapping("/submitVendorAssessmentForm")
    // public ResponseEntity<Object> submitVendorAssessmentForm(@RequestBody VendorAssessmentForm vendorAssessmentForm) {
    //     return ResponseEntity.ok(vendorAssessmentFormRepository.save(vendorAssessmentForm));
    // }

    @GetMapping("/getVendorAssessmentForm")
    public ResponseEntity<Object> getVendorAssessmentForm(@RequestBody VendorAssessmentForm vendorAssessmentForm) {
        return ResponseEntity.ok(vendorAssessmentFormRepository.findById(vendorAssessmentForm.getId()));
    }

    @PostMapping("/updateVendorAssessmentForm")
    public ResponseEntity<Object> updateVendorAssessmentForm(@RequestBody VendorAssessmentForm vendorAssessmentForm) {
        VendorAssessmentForm vendorAssessmentFormToUpdate = vendorAssessmentFormRepository.findById(vendorAssessmentForm.getId()).get();
        if (vendorAssessmentFormToUpdate == null) {
            return ResponseEntity.badRequest().body("Vendor Assessment Form not found");
        }
        vendorAssessmentFormToUpdate.setName(vendorAssessmentForm.getName());
        vendorAssessmentFormToUpdate.setDescription(vendorAssessmentForm.getDescription());
        vendorAssessmentFormToUpdate.setForm(vendorAssessmentForm.getForm());
        vendorAssessmentFormToUpdate.setFormType(vendorAssessmentForm.getFormType());
        vendorAssessmentFormToUpdate.setFormStatus(vendorAssessmentForm.getFormStatus());
        vendorAssessmentFormToUpdate.setFormDate(vendorAssessmentForm.getFormDate());
        vendorAssessmentFormToUpdate.setFormTime(vendorAssessmentForm.getFormTime());
        vendorAssessmentFormToUpdate.setFormLocation(vendorAssessmentForm.getFormLocation());
        vendorAssessmentFormToUpdate.setFormLink(vendorAssessmentForm.getFormLink());
        vendorAssessmentFormToUpdate.setFormLinkText(vendorAssessmentForm.getFormLinkText());

        return ResponseEntity.ok(vendorAssessmentFormRepository.save(vendorAssessmentForm));
    }

    @PostMapping("/createVendorAssessmentForm")
    public ResponseEntity<Object> createVendorAssessmentForm(@RequestBody User user) {
        User vendor = userRepository.findByEmail(user.getEmail()).get();
        if (vendor == null) {
            return ResponseEntity.badRequest().body("Vendor not found");
        }

        VendorAssessmentForm vendorAssessmentForm = new VendorAssessmentForm();
        vendorAssessmentForm.setVendor(vendor);
        
        return ResponseEntity.ok(vendorAssessmentFormRepository.save(vendorAssessmentForm));
    }
    // @GetMapping("/getAllVendorAssessmentForms")
    // public ResponseEntity<Object> getAllVendorAssessmentForms() {
    //     return ResponseEntity.ok(vendorAssessmentFormRepository.findAll());
    // }
}