package com.oop442.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oop442.project.entity.PerformanceEvaluationForm;

public interface PerformanceEvaluationFormRepository extends JpaRepository<PerformanceEvaluationForm, Integer>{
    
}
