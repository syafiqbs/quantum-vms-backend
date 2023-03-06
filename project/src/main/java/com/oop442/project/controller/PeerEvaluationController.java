package com.oop442.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oop442.project.entity.PeerEvaluationForm;
import com.oop442.project.entity.User;
import com.oop442.project.service.PeerEvaluationFormService;
import com.oop442.project.service.UserService;

@RestController
@RequestMapping("/api/v1/vendor")
public class PeerEvaluationController{

    private PeerEvaluationFormService peerEvaluationFormRepository;
    private UserService userRepository;

    public PeerEvaluationController(PeerEvaluationFormService peerEvaluationFormRepository) {
        this.peerEvaluationFormRepository = peerEvaluationFormRepository;
    }

    @PostMapping("/createPeerEvaluationForm")
    public ResponseEntity<Object> createPeerEvaluation(@RequestBody User user) {
        User vendor = userRepository.findByEmail(user.getEmail()).get();
        if (vendor == null) {
            return ResponseEntity.badRequest().body("Vendor not found");
        }
        PeerEvaluationForm peerEvaluationForm = new PeerEvaluationForm();
        peerEvaluationForm.setVendor(vendor);
        
        return ResponseEntity.ok(peerEvaluationFormRepository.save(peerEvaluationForm));
    }

    @PostMapping("/updatePeerEvaluationForm")
    public ResponseEntity<Object> updatePeerEvaluationForm(@RequestBody PeerEvaluationForm peerEvaluationForm) {
        PeerEvaluationForm peerEvaluationFormToUpdate = peerEvaluationFormRepository.findById(peerEvaluationForm.getId()).get();
        if (peerEvaluationFormToUpdate == null) {
            return ResponseEntity.badRequest().body("Peer Evaluation Form not found");
        }
        peerEvaluationFormToUpdate.setName(peerEvaluationForm.getName());
        peerEvaluationFormToUpdate.setDescription(peerEvaluationForm.getDescription());
        peerEvaluationFormToUpdate.setForm(peerEvaluationForm.getForm());
        peerEvaluationFormToUpdate.setFormType(peerEvaluationForm.getFormType());
        peerEvaluationFormToUpdate.setFormStatus(peerEvaluationForm.getFormStatus());
        peerEvaluationFormToUpdate.setFormDate(peerEvaluationForm.getFormDate());
        peerEvaluationFormToUpdate.setFormTime(peerEvaluationForm.getFormTime());
        peerEvaluationFormToUpdate.setFormLocation(peerEvaluationForm.getFormLocation());
        peerEvaluationFormToUpdate.setFormLink(peerEvaluationForm.getFormLink());
        peerEvaluationFormToUpdate.setFormLinkText(peerEvaluationForm.getFormLinkText());

        return ResponseEntity.ok(peerEvaluationFormRepository.save(peerEvaluationForm));
    }

    @GetMapping("/getPeerEvaluationForm")
    public ResponseEntity<Object> getPeerEvaluationForm(@RequestBody PeerEvaluationForm peerEvaluationForm) {
        return ResponseEntity.ok(peerEvaluationFormRepository.findById(peerEvaluationForm.getId()));
    }


}