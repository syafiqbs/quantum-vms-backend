package com.oop442.project.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oop442.project.entity.PerformanceEvaluationForm;

public interface PerformanceEvaluationFormUser extends JpaRepository<PerformanceEvaluationForm, Integer>{
    
}
