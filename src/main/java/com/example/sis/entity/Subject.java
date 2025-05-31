package com.example.sis.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "subject_t")
public class Subject {
    // subject_id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;

    // subject_code
    @Column(name = "subject_code", nullable = false)
    private String subjectCode;

    // subject_name
    @Column(name = "subject_name", nullable = false)
    private String subjectName;

    // credit
    private String credit;
}
