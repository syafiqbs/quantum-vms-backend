package com.oop442.project.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oop442.project.entity.PeerEvaluationForm;

public interface PeerEvaluationFormService extends JpaRepository<PeerEvaluationForm, Integer>{
     
}
