package com.oop442.project.repository;

import com.oop442.project.entity.PerformanceEvaluationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceEvaluationFormRepository extends JpaRepository<PerformanceEvaluationForm, Long>{
    
}
