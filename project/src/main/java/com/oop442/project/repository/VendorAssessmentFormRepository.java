package com.oop442.project.repository;

import com.oop442.project.entity.VendorAssessmentForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorAssessmentFormRepository extends JpaRepository<VendorAssessmentForm, Long>{
    
}
