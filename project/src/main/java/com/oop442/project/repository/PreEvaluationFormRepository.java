package com.oop442.project.repository;

import com.oop442.project.entity.PreEvaluationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreEvaluationFormRepository extends JpaRepository<PreEvaluationForm, Long>{
    
}
