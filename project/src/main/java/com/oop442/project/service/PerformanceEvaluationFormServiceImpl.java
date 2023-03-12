package com.oop442.project.service;

import java.lang.reflect.Field;

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
        Field[] fields = PerformanceEvaluationForm.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(performanceEvaluationForm) != null) {
                    field.set(performanceEvaluationFormToUpdate, field.get(performanceEvaluationForm));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new RuntimeException("Error while updating Performance Evaluation Form");
            }
        }


        return performanceEvaluationFormRepository.save(performanceEvaluationFormToUpdate);
    }

    // @Override
    // public Object deletePerformanceEvaluationForm(Long id) {
    //     PerformanceEvaluationForm performanceEvaluationFormToDelete = performanceEvaluationFormRepository.findById(id).orElseThrow(() -> new PerformanceEvaluationFormNotFoundException(id));
    //     performanceEvaluationFormRepository.delete(performanceEvaluationFormToDelete);
    //     return "Performance Evaluation Form with id " + id + " deleted";
    // }

    @Override
    public Object approvePerformanceEvaluationForm(Long id) {
        PerformanceEvaluationForm performanceEvaluationFormToApprove = performanceEvaluationFormRepository.findById(id).orElseThrow(() -> new PerformanceEvaluationFormNotFoundException(id));
        performanceEvaluationFormToApprove.setPerformanceEvaluationResults("Approved");
        return performanceEvaluationFormRepository.save(performanceEvaluationFormToApprove);
    }

    
}
