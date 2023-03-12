package com.oop442.project.service;

import com.oop442.project.entity.PerformanceEvaluationForm;

public interface PerformanceEvaluationFormService {

    PerformanceEvaluationForm getPerformanceEvaluationForm(Long id);

    Object getPerformanceAllEvaluationForms();

    Object updatePerformanceEvaluationForm(PerformanceEvaluationForm performanceEvaluationForm);

    // Object deletePerformanceEvaluationForm(Long id);

    Object approvePerformanceEvaluationForm(Long id);
}
