package com.oop442.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oop442.project.entity.PerformanceEvaluationForm;
import com.oop442.project.error.PerformanceEvaluationFormNotFoundException;
import com.oop442.project.repository.PerformanceEvaluationFormRepository;

@Service
public class PerformanceEvaluationFormServiceImpl implements PerformanceEvaluationFormService {

    @Autowired
    private PerformanceEvaluationFormRepository performanceEvaluationFormRepository;

    @Override
    public PerformanceEvaluationForm getPerformanceEvaluationForm(Long id) {
        return performanceEvaluationFormRepository.findById(id).orElseThrow(() -> new PerformanceEvaluationFormNotFoundException(id));
    }

    @Override
    public Object getPerformanceAllEvaluationForms() {
        return performanceEvaluationFormRepository.findAll();
    }

    @Override
    public Object updatePerformanceEvaluationForm(PerformanceEvaluationForm performanceEvaluationForm) {
        PerformanceEvaluationForm performanceEvaluationFormToUpdate = performanceEvaluationFormRepository.findById(performanceEvaluationForm.getId()).orElseThrow(() -> new PerformanceEvaluationFormNotFoundException(performanceEvaluationForm.getId()));
        performanceEvaluationFormToUpdate.setCompanyAddress(performanceEvaluationForm.getCompanyAddress());
        performanceEvaluationFormToUpdate.setCompanyName(performanceEvaluationForm.getCompanyName());
        performanceEvaluationFormToUpdate.setPerformanceEvaluationResults(performanceEvaluationForm.getPerformanceEvaluationResults());

        return performanceEvaluationFormRepository.save(performanceEvaluationFormToUpdate);
    }

    @Override
    public Object deletePerformanceEvaluationForm(Long id) {
        PerformanceEvaluationForm performanceEvaluationFormToDelete = performanceEvaluationFormRepository.findById(id).orElseThrow(() -> new PerformanceEvaluationFormNotFoundException(id));
        performanceEvaluationFormRepository.delete(performanceEvaluationFormToDelete);
        return "Performance Evaluation Form with id " + id + " deleted";
    }
    
}
