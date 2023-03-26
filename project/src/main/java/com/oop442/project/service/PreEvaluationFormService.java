package com.oop442.project.service;

import com.oop442.project.entity.PreEvaluationForm;

public interface PreEvaluationFormService {

    Object createPreEvaluationForm(String userEmail, Integer deadline);

    Object getPreEvaluationForm(Long id);

    Object getAllPreEvaluationForms();

    Object updatePreEvaluationForm(PreEvaluationForm preEvaluationForm);

    Object deletePreEvaluationForm(Long id);

    Object approvePreEvaluationForm(Long id, String status);

}
