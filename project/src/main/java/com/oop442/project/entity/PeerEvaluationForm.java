package com.oop442.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PeerEvaluationForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private String form;
    private String formType;
    private String formStatus;
    private String formDate;
    private String formTime;
    private String formLocation;
    private String formLink;
    private String formLinkText;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User vendor;

}
