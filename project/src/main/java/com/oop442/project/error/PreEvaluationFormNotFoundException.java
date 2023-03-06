package com.oop442.project.error;

public class PreEvaluationFormNotFoundException extends RuntimeException{

    public PreEvaluationFormNotFoundException(Long id) {
        super("Pre Evaluation Form not found with id: " + id);
    }

}
