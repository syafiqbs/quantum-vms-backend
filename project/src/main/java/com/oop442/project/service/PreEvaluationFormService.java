package com.oop442.project.service;

import com.oop442.project.entity.PreEvaluationForm;

public interface PreEvaluationFormService {

    Object getPreEvaluationForm(Long id);

    Object getAllPreEvaluationForms();

    Object updatePreEvaluationForm(PreEvaluationForm preEvaluationForm);

    Object deletePreEvaluationForm(Long id);

}