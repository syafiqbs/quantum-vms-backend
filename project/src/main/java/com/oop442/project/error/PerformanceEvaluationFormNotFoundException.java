package com.oop442.project.error;

public class PerformanceEvaluationFormNotFoundException extends RuntimeException{

    public PerformanceEvaluationFormNotFoundException(Long id) {
        super("Performance Evaluation Form not found with id: " + id);
    }

}
