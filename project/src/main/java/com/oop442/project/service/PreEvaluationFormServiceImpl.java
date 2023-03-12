package com.oop442.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oop442.project.entity.PreEvaluationForm;
import com.oop442.project.error.PreEvaluationFormNotFoundException;
import com.oop442.project.repository.PreEvaluationFormRepository;

@Service
public class PreEvaluationFormServiceImpl implements PreEvaluationFormService{

    @Autowired
    private PreEvaluationFormRepository preEvaluationFormRepository;
    
    @Override
    public Object getPreEvaluationForm(Long id) {
        return preEvaluationFormRepository.findById(id).orElseThrow(() -> new PreEvaluationFormNotFoundException(id));
    }

    @Override
    public Object getAllPreEvaluationForms() {
        return preEvaluationFormRepository.findAll();
    }

    @Override
    public Object updatePreEvaluationForm(PreEvaluationForm preEvaluationForm) {
        PreEvaluationForm preEvaluationFormToUpdate = preEvaluationFormRepository.findById(preEvaluationForm.getId()).orElseThrow(() -> new PreEvaluationFormNotFoundException(preEvaluationForm.getId()));
        preEvaluationFormToUpdate.setCompanyAddress(preEvaluationForm.getCompanyAddress());
        preEvaluationFormToUpdate.setCompanyName(preEvaluationForm.getCompanyName());

        return preEvaluationFormRepository.save(preEvaluationFormToUpdate);
    }

    @Override
    public Object deletePreEvaluationForm(Long id) {
        PreEvaluationForm preEvaluationFormToDelete = preEvaluationFormRepository.findById(id).orElseThrow(() -> new PreEvaluationFormNotFoundException(id));
        preEvaluationFormRepository.delete(preEvaluationFormToDelete);
        return "Pre Evaluation Form deleted with id: " + id;
    }

    @Override
    public Object approvePreEvaluationForm(Long id) {
        PreEvaluationForm preEvaluationFormToApprove = preEvaluationFormRepository.findById(id).orElseThrow(() -> new PreEvaluationFormNotFoundException(id));
        preEvaluationFormToApprove.setPreEvaluationResults("true");
        return preEvaluationFormRepository.save(preEvaluationFormToApprove);
    }
    
}
